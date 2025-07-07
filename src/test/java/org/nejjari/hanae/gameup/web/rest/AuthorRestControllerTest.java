package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.dto.AuthorDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;

import java.util.Collections;

public class AuthorRestControllerTest extends SuperAbstractRestControllerTest<AuthorDto> {


    @Override
    protected void defineDTO() {
        super.dto = new AuthorDto(null, "name", Collections.emptyList());
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = AuthorDto.class;
    }

    @Override
    protected String getBasePath() {
        return AuthorRestController.BASE_PATH;
    }

    @Override
    protected AuthorDto newForChangesFromTo(AuthorDto from) {
        return new AuthorDto(from.id(), from.id() + from.name(), Collections.emptyList());
    }

}
