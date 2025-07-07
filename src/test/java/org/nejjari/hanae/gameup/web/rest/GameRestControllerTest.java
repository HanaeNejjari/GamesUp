package org.nejjari.hanae.gameup.web.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.dto.GameDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.nejjari.hanae.gameup.web.rest.GameRestController.BASE_PATH_RECOMMENDATIONS;
import static org.nejjari.hanae.gameup.web.rest.GameRestController.BASE_PATH_SEARCH;

public class GameRestControllerTest extends SuperAbstractRestControllerTest<GameDto> {

    public static final String PARAM_NOM_NOM = "?nom=nom";


    @Override
    protected void defineDTO() {
        super.dto = new GameDto(null, "nom", "auteur", "genre", null, null, "numEdition");
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = GameDto.class;
    }

    @Override
    protected String getBasePath() {
        return GameRestController.BASE_PATH;
    }

    @Override
    protected GameDto newForChangesFromTo(GameDto from) {
        return new GameDto(from.id(), from.id() + from.nom(), from.id() + from.auteur(), from.id() + from.genre(), from.category(), from.publisher(), from.id() + from.numEdition());
    }

    /**
     * Test Search
     */
    @Test
    public void testSearch() {
        super.testSave();
        Set<GameDto> search = (Set<GameDto>) restTemplate.withBasicAuth(ADMIN, ADMIN)
                .getForObject(url + BASE_PATH_SEARCH + PARAM_NOM_NOM, Set.class);
        Assertions.assertTrue(search.size() > 0);
    }

    /**
     * Test recommendations up to 5 games
     */
    @Test
    public void testRecommendations() {
        super.testSave();
        super.testSave();
        super.testSave();
        super.testSave();
        super.testSave();
        ResponseEntity<Set> forEntity = restTemplate.withBasicAuth(ADMIN, ADMIN).getForEntity(url + BASE_PATH_RECOMMENDATIONS, Set.class);
        Set<GameDto> recommendations = (Set<GameDto>) forEntity.getBody();
        Assertions.assertNotNull(recommendations);
    }


}
