package org.nejjari.hanae.gameup.base;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Base class for wiremock tests FastApi external microservice
 */
public abstract class AbstractWireMockGameServiceToFastApiTest {
    protected static WireMockServer wireMockServer;

    /**
     * Override properties for fastapi
     *
     * @param registry registry
     */
    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("fastapi.recommendations.url", () -> "http://localhost:8081/recommendations");
        registry.add("fastapi.train.url", () -> "http://localhost:8081/training");
    }

    /**
     * Initialize wiremock
     *
     * @throws Exception exception
     */
    @BeforeAll
    public static void init() throws Exception {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8081));
        wireMockServer.start();

        // Stub /recommendations
        String recommendationsJson = Files.readString(Paths.get("src/test/resources/recommentation.json"));
        wireMockServer.stubFor(WireMock.post("/recommendations")
                .willReturn(WireMock.jsonResponse("{\"recommendations\":[{\"game_id\":1,\"estimated_score\":4.5}]}", 200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(recommendationsJson)));

        // Stub /training
        wireMockServer.stubFor(WireMock.post("/training")
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"message\": \"Modèle KNN entraîné avec succès (simulation)\"}")));
    }

    /**
     * Clean up wiremock
     */
    @AfterAll
    public static void teardown() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }
}
