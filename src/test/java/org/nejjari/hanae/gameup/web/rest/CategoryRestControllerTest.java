package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.dto.CategoryDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;

public class CategoryRestControllerTest extends SuperAbstractRestControllerTest<CategoryDto> {


    @Override
    protected void defineDTO() {
        super.dto = new CategoryDto(null, "type");
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = CategoryDto.class;
    }

    @Override
    protected String getBasePath() {
        return CategoryRestController.BASE_PATH;
    }

    @Override
    protected CategoryDto newForChangesFromTo(CategoryDto from) {
        return new CategoryDto(from.id(), from.id() + from.type());
    }

}
