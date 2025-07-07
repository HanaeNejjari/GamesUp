package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.dto.PurchaseLineDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;

public class PurchaseLineRestControllerTest extends SuperAbstractRestControllerTest<PurchaseLineDto> {


    @Override
    protected void defineDTO() {
        super.dto = new PurchaseLineDto(null, 1L, 1L, 5.0D);
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = PurchaseLineDto.class;
    }

    @Override
    protected String getBasePath() {
        return PurchaseLineRestController.BASE_PATH;
    }

    @Override
    protected PurchaseLineDto newForChangesFromTo(PurchaseLineDto from) {
        return new PurchaseLineDto(from.id(), from.id() + from.utilisateurId(), from.id() + from.jeuId(), from.prix() + 1.0D);
    }

}
