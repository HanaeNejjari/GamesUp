package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.WishlistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Integration test for the WishlistService.
 * <p>
 * Verifies that the service layer correctly handles operations on WishlistDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class WishlistServiceTest extends SuperServiceTest<WishlistDto, WishlistService> {


    /**
     * Constructs the test class with the injected WishlistService.
     *
     * @param service the WishlistService to be tested
     */
    @Autowired
    public WishlistServiceTest(WishlistService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new WishlistDto(null, Collections.emptyList());
    }
}
