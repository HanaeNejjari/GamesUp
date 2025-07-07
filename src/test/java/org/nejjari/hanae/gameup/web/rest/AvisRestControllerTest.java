package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.dto.AvisDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;

public class AvisRestControllerTest extends SuperAbstractRestControllerTest<AvisDto> {


    @Override
    protected void defineDTO() {
        super.dto = new AvisDto(null, "commentaire", 1);
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = AvisDto.class;
    }

    @Override
    protected String getBasePath() {
        return AvisRestController.BASE_PATH;
    }

    @Override
    protected AvisDto newForChangesFromTo(AvisDto from) {
        return new AvisDto(from.id(), from.id() + from.commentaire(), from.note() + 1);
    }

}
