package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test for the AuthorService.
 * <p>
 * Verifies that the service layer correctly handles operations on AuthorDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class AuthorServiceTest extends SuperServiceTest<AuthorDto, AuthorService> {


    /**
     * Constructs the test class with the injected AuthorService.
     *
     * @param service the AuthorService to be tested
     */
    @Autowired
    public AuthorServiceTest(AuthorService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new AuthorDto(null, "fullname", null);
    }
}
