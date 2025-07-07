package org.nejjari.hanae.gameup.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.base.AbstractWireMockGameServiceToFastApiTest;
import org.nejjari.hanae.gameup.dto.base.SuperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SuperAbstractRestControllerTest<DTO extends SuperDto> extends AbstractWireMockGameServiceToFastApiTest {

    public static final String QUERY_ID = "?id=";
    protected static final String ADMIN = "Admin";
    protected DTO dto;
    protected Class<DTO> dtoClass;


    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate restTemplate;

    protected String url;

    @BeforeEach
    protected void setUp() {
        defineDTO();
        defineUrl();
        defineClassDTO();
    }

    protected abstract void defineDTO();

    protected abstract void defineClassDTO();

    protected abstract String getBasePath();

    protected abstract DTO newForChangesFromTo(DTO from);


    protected void defineUrl() {
        this.url = "http://localhost:" + port + getBasePath();
    }

    @Test
    public void testSave() {
        ResponseEntity<DTO> response = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .postForEntity(url, dto, dtoClass);
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void testFindById() {
        ResponseEntity<DTO> response = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .postForEntity(url, dto, dtoClass);
        ResponseEntity<DTO> result = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .getForEntity(url + QUERY_ID + response.getBody().getIdentifier(), dtoClass);
        Assertions.assertNotNull(result.getBody());
    }

    @Test
    public void testFindAll() {
        restTemplate.withBasicAuth(ADMIN, ADMIN).postForEntity(url, dto, dtoClass);
        ResponseEntity<List> result = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .getForEntity(url + "/all", List.class);
        List<DTO> body = (List<DTO>) result.getBody();
        Assertions.assertNotEquals(0, body.size());
    }

    @Test
    public void testUpdateByPut() {
        ResponseEntity<DTO> response = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .postForEntity(url, dto, dtoClass);
        DTO from = response.getBody();
        DTO to = newForChangesFromTo(from);
        restTemplate.withBasicAuth(ADMIN, ADMIN).put(url, to);
        ResponseEntity<DTO> result = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .getForEntity(url + QUERY_ID + to.getIdentifier(), dtoClass);
        Assertions.assertEquals(to, result.getBody());
    }

    @Test
    public void testUpdateByPatch() {
        ResponseEntity<DTO> response = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .postForEntity(url, dto, dtoClass);
        DTO from = response.getBody();
        DTO to = newForChangesFromTo(from);
        DTO patched = restTemplate.withBasicAuth(ADMIN, ADMIN)
                .patchForObject(url, to, dtoClass);
        Assertions.assertEquals(to, patched);
    }

}
