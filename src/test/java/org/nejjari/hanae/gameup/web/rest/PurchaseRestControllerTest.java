package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.dto.PurchaseDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;

import java.time.LocalDate;
import java.util.Collections;

public class PurchaseRestControllerTest extends SuperAbstractRestControllerTest<PurchaseDto> {


    @Override
    protected void defineDTO() {
        super.dto = new PurchaseDto(null, Collections.emptyList(), LocalDate.now(), false, false, false);
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = PurchaseDto.class;
    }

    @Override
    protected String getBasePath() {
        return PurchaseRestController.BASE_PATH;
    }

    @Override
    protected PurchaseDto newForChangesFromTo(PurchaseDto from) {
        return new PurchaseDto(from.id(), from.line(), from.date(), !from.paid(), !from.delivered(), !from.archived());
    }

}
