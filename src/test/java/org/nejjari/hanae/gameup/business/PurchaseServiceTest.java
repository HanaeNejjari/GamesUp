package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;

/**
 * Integration test for the PurchaseService.
 * <p>
 * Verifies that the service layer correctly handles operations on PurchaseDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class PurchaseServiceTest extends SuperServiceTest<PurchaseDto, PurchaseService> {


    /**
     * Constructs the test class with the injected PurchaseService.
     *
     * @param service the PurchaseService to be tested
     */
    @Autowired
    public PurchaseServiceTest(PurchaseService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new PurchaseDto(null, Collections.emptyList(), LocalDate.now(), false, false, true);
    }
}
