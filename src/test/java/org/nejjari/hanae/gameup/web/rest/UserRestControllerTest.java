package org.nejjari.hanae.gameup.web.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.dto.UserDto;
import org.nejjari.hanae.gameup.web.SuperAbstractRestControllerTest;
import org.nejjari.hanae.gameup.web.security.SecurityConfig;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static org.nejjari.hanae.gameup.web.rest.UserRestController.*;

public class UserRestControllerTest extends SuperAbstractRestControllerTest<UserDto> {


    public static final String MOT_DE_PASSE_HASH = "1WXCVBN@azerty";
    public static final String NOM = "nom";
    public static final String PARAM_NOM_ADMIN = "?nom=" + ADMIN;
    public static int counter = 0;

    @Override
    protected void defineDTO() {
        super.dto = new UserDto(null, NOM + (++counter), MOT_DE_PASSE_HASH, List.of(SecurityConfig.ADMIN, SecurityConfig.USER));
    }

    @Override
    protected void defineClassDTO() {
        super.dtoClass = UserDto.class;
    }

    @Override
    protected String getBasePath() {
        return UserRestController.BASE_PATH;
    }

    @Override
    protected UserDto newForChangesFromTo(UserDto from) {
        return new UserDto(from.id(), from.id() + NOM, from.id() + MOT_DE_PASSE_HASH, Collections.emptyList());
    }

    @Override
    @Test
    public void testUpdateByPatch() {
        defineDTO();
        ResponseEntity<UserDto> response = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .postForEntity(url, dto, dtoClass);
        UserDto from = response.getBody();
        UserDto to = newForChangesFromTo(from);
        UserDto patched = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .patchForObject(url, to, dtoClass);
        Assertions.assertEquals(to.nom(), patched.nom());
    }

    @Override
    @Test
    public void testUpdateByPut() {
        defineDTO();
        ResponseEntity<UserDto> response = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .postForEntity(url, dto, dtoClass);
        UserDto from = response.getBody();
        UserDto to = newForChangesFromTo(from);
        restTemplate.withBasicAuth(ADMIN, ADMIN).put(url, to);
        ResponseEntity<UserDto> result = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .getForEntity(url + QUERY_ID + to.getIdentifier(), dtoClass);
        Assertions.assertEquals(to.nom(), result.getBody().nom());
    }

    @Test
    public void testVerifyByLogin() {
        dto = new UserDto(null, ADMIN, ADMIN, List.of(SecurityConfig.ADMIN, SecurityConfig.USER));
        Boolean verified = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .postForObject(url + BASE_PATH_VERIFY_LOGIN, dto, Boolean.class);
        Assertions.assertTrue(verified);
    }

    @Test
    public void testGetUserByNom() throws URISyntaxException {
        UserDto got = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .getForObject(url + BASE_PATH_GET_BY_NOM + PARAM_NOM_ADMIN, dtoClass);
        Assertions.assertEquals(ADMIN, got.nom());
    }


    @Test
    public void testExistByNom() {
        Boolean verified = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .getForObject(url + BASE_PATH_EXIST_BY_NOM + PARAM_NOM_ADMIN, Boolean.class);
        Assertions.assertTrue(verified);
    }

}
