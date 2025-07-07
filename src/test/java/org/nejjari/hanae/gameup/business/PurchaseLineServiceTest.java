package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.PurchaseLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test for the PurchaseLineService.
 * <p>
 * Verifies that the service layer correctly handles operations on PurchaseLineDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class PurchaseLineServiceTest extends SuperServiceTest<PurchaseLineDto, PurchaseLineService> {


    /**
     * Constructs the test class with the injected PurchaseLineService.
     *
     * @param service the PurchaseLineService to be tested
     */
    @Autowired
    public PurchaseLineServiceTest(PurchaseLineService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new PurchaseLineDto(null, 2L, 3L, 10D);
    }
}
