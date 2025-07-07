package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.InventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * Integration test for the InventoryService.
 * <p>
 * Verifies that the service layer correctly handles operations on InventoryDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class InventoryServiceTest extends SuperServiceTest<InventoryDto, InventoryService> {


    /**
     * Constructs the test class with the injected InventoryService.
     *
     * @param service the InventoryService to be tested
     */
    @Autowired
    public InventoryServiceTest(InventoryService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new InventoryDto(null, HashMap.newHashMap(0));
    }
}
