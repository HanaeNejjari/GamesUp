package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperServiceTest;
import org.nejjari.hanae.gameup.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test for the CategoryService.
 * <p>
 * Verifies that the service layer correctly handles operations on CategoryDto.
 * Inherits generic test logic from SuperServiceTest.
 * </p>
 */
@SpringBootTest
@Transactional
public class CategoryServiceTest extends SuperServiceTest<CategoryDto, CategoryService> {


    /**
     * Constructs the test class with the injected CategoryService.
     *
     * @param service the CategoryService to be tested
     */
    @Autowired
    public CategoryServiceTest(CategoryService service) {
        super(service);
    }

    /**
     * Initializes the DTO used in the test methods.
     */
    @Override
    public void initDTO() {
        super.dto = new CategoryDto(null, "category");
    }
}
