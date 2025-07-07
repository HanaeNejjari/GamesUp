package org.nejjari.hanae.gameup.business;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.UserDto;
import org.nejjari.hanae.gameup.web.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Integration test for the UserService.
 * <p>
 * Verifies that the service layer correctly handles operations on UserDto,
 * including custom methods like findByNom, verifyLogin, and existByNom.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class UserServiceTest extends SuperServiceTest<UserDto, UserService> {


    /**
     * Constructs the test class with the injected UserService.
     *
     * @param service the UserService to be tested
     */
    @Autowired
    public UserServiceTest(UserService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new UserDto(
                null,
                "nom",
                "motDePasse",
                List.of(SecurityConfig.ADMIN, SecurityConfig.USER)
        );
    }

    /**
     * Tests the custom service method for finding a user by name.
     */
    @Test
    public void testFindByNom() {
        superService.findByNom("nom");
    }

    /**
     * Tests the custom service method for verifying login credentials.
     */
    @Test
    public void testVerifyLogin() {
        superService.verifyLogin(dto);
    }

    /**
     * Tests the custom service method for checking if a user exists by name.
     */
    @Test
    public void testExistByNom() {
        superService.existByNom("nom");
    }

    /**
     * Overrides and tests saving or updating a user.
     */
    @Override
    @Test
    public void testSaveOrUpdate() {
        dto = new UserDto(null, "nom", "motDePasse", List.of(SecurityConfig.ADMIN, SecurityConfig.USER));
        super.testSaveOrUpdate();
    }

    /**
     * Overrides and tests finding a user by ID.
     */
    @Override
    @Test
    public void testFindById() {
        dto = new UserDto(null, "nom2", "motDePasse", List.of(SecurityConfig.ADMIN, SecurityConfig.USER));
        super.testFindById();
    }

    /**
     * Overrides and tests deleting a user by ID.
     */
    @Override
    @Test
    public void testDeleteById() {
        dto = new UserDto(null, "nom3", "motDePasse", List.of(SecurityConfig.ADMIN, SecurityConfig.USER));
        super.testDeleteById();
    }
}
