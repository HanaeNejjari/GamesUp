package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.dto.PublisherDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;

public class PublisherRestControllerTest extends SuperAbstractRestControllerTest<PublisherDto> {


    @Override
    protected void defineDTO() {
        super.dto = new PublisherDto(null, "name");
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = PublisherDto.class;
    }

    @Override
    protected String getBasePath() {
        return PublisherRestController.BASE_PATH;
    }

    @Override
    protected PublisherDto newForChangesFromTo(PublisherDto from) {
        return new PublisherDto(from.id(), from.id() + from.name());
    }

}
