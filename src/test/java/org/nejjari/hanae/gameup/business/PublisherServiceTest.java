package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.PublisherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test for the PublisherService.
 * <p>
 * Verifies that the service layer correctly handles operations on PublisherDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class PublisherServiceTest extends SuperServiceTest<PublisherDto, PublisherService> {


    /**
     * Constructs the test class with the injected PublisherService.
     *
     * @param service the PublisherService to be tested
     */
    @Autowired
    public PublisherServiceTest(PublisherService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new PublisherDto(null, "publisher");
    }
}
