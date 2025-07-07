package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.AvisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test for the AvisService.
 * <p>
 * Verifies that the service layer correctly handles operations on AvisDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class AvisServiceTest extends SuperServiceTest<AvisDto, AvisService> {


    /**
     * Constructs the test class with the injected AvisService.
     *
     * @param service the AvisService to be tested
     */
    @Autowired
    public AvisServiceTest(AvisService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new AvisDto(null, "commentaire", 5);
    }
}
