package org.nejjari.hanae.gameup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the GameUp Spring Boot application.
 * <p>
 * This class bootstraps the application using Spring Boot's auto-configuration
 * and component scanning features.
 * </p>
 *
 * @SpringBootApplication is a convenience annotation that adds:
 * - @Configuration: Tags the class as a source of bean definitions.
 * - @EnableAutoConfiguration: Enables Spring Boot’s auto-configuration mechanism.
 * - @ComponentScan: Enables component scanning for the package.
 */
@SpringBootApplication
public class GameUpApplication {

    /**
     * Main method that launches the Spring Boot application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(GameUpApplication.class, args);
    }

}
