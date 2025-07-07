package org.nejjari.hanae.gameup.web.rest;

import lombok.SneakyThrows;
import org.nejjari.hanae.gameup.business.GameService;
import org.nejjari.hanae.gameup.dto.GameDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * REST controller for handling game-related web requests.
 */
@RestController
@RequestMapping(GameRestController.BASE_PATH)
public class GameRestController extends SuperRestController<GameDto, GameService> {


    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/game";
    public static final String BASE_PATH_SEARCH = "/search";
    public static final String BASE_PATH_RECOMMENDATIONS = "/recommendations";

    /**
     * Constructor injecting the GameService instance.
     *
     * @param service The injected GameService instance used to perform business logic operations on games.
     */
    @Autowired
    protected GameRestController(GameService service) {
        super(service);
    }

    /**
     * Handles GET requests for searching distinct game DTOs by multiple criteria (nom, genre, etc.).
     *
     * @param nom           The name of the game to search for.
     * @param genre         The genre of the game to filter by.
     * @param numEdition    The edition number of the game to filter by.
     * @param auteur        The author/developer of the game to filter by.
     * @param categoryType  The type/category of the game to filter by.
     * @param publisherName The publisher name of the game to filter by.
     * @return A set containing distinct GameDto objects matching any of the provided criteria.
     */
    @GetMapping(path = BASE_PATH_SEARCH)
    public Set<GameDto> distinctSearchByNomOrGenreOrNumEditionOrAuteurOrCategoryTypeOrPublisherName
    (@RequestParam(value = "nom", required = false) String nom, @RequestParam(value = "genre", required = false) String genre, @RequestParam(value = "numEdition", required = false) String numEdition,
     @RequestParam(value = "auteur", required = false) String auteur, @RequestParam(value = "categoryType", required = false) String categoryType, @RequestParam(value = "publisherName", required = false) String publisherName) {
        return service.
                distinctSearchByNomOrGenreOrNumEditionOrAuteurOrCategoryTypeOrPublisherName
                        (nom, genre, numEdition, auteur, categoryType, publisherName);
    }

    /**
     * Returns a set of recommended games based on the AI recommendation algorithm.
     *
     * @return a set of recommended GameDto objects.
     */
    @SneakyThrows
    @GetMapping(path = BASE_PATH_RECOMMENDATIONS)
    public Set<GameDto> getRecommandedGameByAI() {
        return service.getRecommandedGameByAIWithFastAPI();
    }

}