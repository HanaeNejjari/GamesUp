package org.nejjari.hanae.gameup.business;

import jakarta.annotation.PostConstruct;
import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.GameDto;
import org.nejjari.hanae.gameup.dto.GameRecommendationsDto;
import org.nejjari.hanae.gameup.entity.GameEntity;
import org.nejjari.hanae.gameup.mapper.GameMapper;
import org.nejjari.hanae.gameup.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service providing business logic and CRUD operations for games.
 * Extends the generic SuperService for GameEntity and GameDto.
 * Handles integration with FastAPI for recommendations and training.
 */
@Service
@Transactional
public class GameService extends SuperService<GameEntity, GameDto, GameRepository, GameMapper> {

    /**
     * The character encoding for the HTTP request body.
     */
    public static final String UTF_8 = "UTF-8";
    /**
     * The HTTP headers for the HTTP request body.
     */
    public static final HttpHeaders HTTP_HEADERS = new HttpHeaders();

    static {
        HTTP_HEADERS.setContentType(MediaType.APPLICATION_JSON);
    }

    /**
     * The RestTemplate instance for making HTTP requests to FastAPI.
     */
    private final RestTemplate restTemplate;
    /**
     * The URL of the FastAPI endpoint for retrieving recommendations.
     */
    @Value("${fastapi.recommendations.url}")
    private String fastApiUrlRecommendations;
    /**
     * The URL of the FastAPI endpoint for training.
     */
    @Value("${fastapi.train.url}")
    private String fastApiUrlTraining;
    @Value("classpath:train.json")
    private Resource train;
    @Value("classpath:recommentation.json")
    private Resource recommentation;

    /**
     * Constructs a GameService with the specified repository and mapper.
     *
     * @param repository the game repository to use
     * @param mapper     the game mapper to use
     */
    @Autowired
    public GameService(GameRepository repository, GameMapper mapper, RestTemplateBuilder restTemplateBuilder) {
        super(repository, mapper);
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Retrieves a distinct set of games matching any of the provided search criteria:
     * name, genre, edition number, author, category type, or publisher name.
     *
     * @param nom           the name of the game to search for
     * @param genre         the genre of the game to search for
     * @param numEdition    the edition number of the game to search for
     * @param auteur        the author of the game to search for
     * @param categoryType  the category type of the game to search for
     * @param publisherName the publisher name of the game to search for
     * @return a set of distinct GameDto objects matching the search criteria
     */
    public Set<GameDto> distinctSearchByNomOrGenreOrNumEditionOrAuteurOrCategoryTypeOrPublisherName(String nom, String genre, String numEdition, String auteur, String categoryType, String publisherName) {
        return repository
                .distinctSearchByNomOrGenreOrNumEditionOrAuteurOrCategoryTypeOrPublisherName(nom, genre, numEdition, auteur, categoryType, publisherName)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    /**
     * Retrieves the top 5 recommended games using FastAPI.
     *
     * @return a set of distinct GameDto objects representing the top 5 recommended games
     */
    public Set<GameDto> getRecommandedGameByAIWithFastAPI() throws IOException, URISyntaxException {
        HttpEntity<String> entity = new HttpEntity<>(recommentation.getContentAsString(StandardCharsets.UTF_8), HTTP_HEADERS);
        ResponseEntity<GameRecommendationsDto> tResponseEntity = restTemplate.postForEntity(new URI(fastApiUrlRecommendations), entity, GameRecommendationsDto.class);
        GameRecommendationsDto gameRecommendationsDto = tResponseEntity.getBody();
        return Optional.ofNullable(gameRecommendationsDto.recommendations()).orElse(List.of()).stream().sorted()
                .map(gameRecommendationDto -> gameRecommendationDto.getIdentifier())
                .map(id -> repository.findById(id).orElse(new GameEntity()))
                .map(mapper::toDto)
                .collect(Collectors.toUnmodifiableSet());
    }

    /**
     * Trains the game recommendation model using FastAPI.
     *
     * @throws IOException        when there is an error reading the training data.
     * @throws URISyntaxException when there is an error constructing the URI for the FastAPI endpoint.
     */
    @PostConstruct
    private void training() throws IOException, URISyntaxException {
        HttpEntity<String> entity = new HttpEntity<>(train.getContentAsString(StandardCharsets.UTF_8), HTTP_HEADERS);
        ResponseEntity<String> tResponseEntity = restTemplate.postForEntity(new URI(fastApiUrlTraining), entity, String.class);
        Assert.hasText("Modèle KNN entraîné avec succès (simulation)", Objects.requireNonNull(tResponseEntity.getBody()));
    }

}