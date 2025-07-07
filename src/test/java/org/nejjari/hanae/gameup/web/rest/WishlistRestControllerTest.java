package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.dto.WishlistDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;

import java.util.Arrays;
import java.util.List;

public class WishlistRestControllerTest extends SuperAbstractRestControllerTest<WishlistDto> {


    public static final String JEU_1 = "jeu1";

    @Override
    protected void defineDTO() {
        super.dto = new WishlistDto(null, List.of(JEU_1));
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = WishlistDto.class;
    }

    @Override
    protected String getBasePath() {
        return WishlistRestController.BASE_PATH;
    }

    @Override
    protected WishlistDto newForChangesFromTo(WishlistDto from) {
        return new WishlistDto(from.id(), Arrays.asList(JEU_1, "jeu2"));
    }

}
