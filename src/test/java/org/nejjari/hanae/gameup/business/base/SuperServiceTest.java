package org.nejjari.hanae.gameup.business.base;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.base.AbstractWireMockGameServiceToFastApiTest;
import org.nejjari.hanae.gameup.dto.base.SuperDto;
import org.nejjari.hanae.gameup.mapper.base.SuperMapper;
import org.nejjari.hanae.gameup.repository.base.SuperRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Abstract base class for service layer integration tests.
 * <p>
 * This class provides reusable test methods for verifying the behavior of
 * service classes that extend {@link SuperService}. It supports generic DTOs,
 * services, repositories, and mappers.
 * </p>
 *
 * @param <DTO> the type of the Data Transfer Object
 * @param <S>   the type of the service being tested
 */
public abstract class SuperServiceTest<
        DTO extends SuperDto,
        S extends SuperService<?, DTO, ? extends SuperRepository<?>, ? extends SuperMapper<DTO, ?>>
        > extends AbstractWireMockGameServiceToFastApiTest {
    /**
     * The service instance under test.
     */
    protected final S superService;

    /**
     * A sample DTO instance used in test methods.
     */
    protected DTO dto;

    /**
     * Constructs the test class with the specified service.
     *
     * @param superService the service to be tested
     */
    public SuperServiceTest(S superService) {
        this.superService = superService;
        initDTO();
    }

    /**
     * Initializes the DTO instance before running tests.
     */
    public abstract void initDTO();

    /**
     * Tests saving or updating a single DTO.
     */
    @Test
    public void testSaveOrUpdate() {
        assertNotNull(superService.saveOrUpdate(dto));
    }

    /**
     * Tests saving or updating a list of DTOs.
     */
    @Test
    public void testSaveOrUpdateAll() {
        List<DTO> dtos = List.of(dto);
        assertNotNull(superService.saveOrUpdateAll(dtos));
    }

    /**
     * Tests finding a DTO by its identifier.
     */
    @Test
    public void testFindById() {
        dto = superService.saveOrUpdate(dto);
        superService.findById(dto.getIdentifier());
    }

    /**
     * Tests retrieving all DTOs.
     */
    @Test
    public void testFindAll() {
        assertNotNull(superService.findAll());
    }

    /**
     * Tests retrieving DTOs by a list of identifiers.
     */
    @Test
    public void testFindAllById() {
        List<Long> ids = List.of(1L, 2L, 3L);
        assertNotNull(superService.findAllById(ids));
    }

    /**
     * Tests deleting a DTO by its identifier.
     */
    @Test
    public void testDeleteById() {
        SuperDto superDto = superService.saveOrUpdate(dto);
        superService.deleteById(superDto.getIdentifier());
    }
}
