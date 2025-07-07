package org.nejjari.hanae.gameup.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;


/**
 * Integration test for the GameService.
 * <p>
 * Verifies that the service layer correctly handles operations on GameDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class GameServiceTest extends SuperServiceTest<GameDto, GameService> {

    /**
     * Constructs the test class with the injected GameService.
     *
     * @param service the GameService to be tested
     */
    @Autowired
    public GameServiceTest(GameService service) {
        super(service);
    }

    /**
     * Tests recommendations of games, up to 5.
     *
     * @throws IOException        if there is an issue with reading the JSON file
     * @throws URISyntaxException if there is an issue with the URI
     */
    @Test
    public void testGetRecommendedGames() throws IOException, URISyntaxException {
        Assertions.assertNotNull(superService.getRecommandedGameByAIWithFastAPI());
    }

    @Override
    public void initDTO() {
        super.dto = new GameDto(null, "nom", "auteur", "genre", null, null, "numEdition");
    }
}
