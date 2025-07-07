package org.nejjari.hanae.gameup.business.base;

import org.nejjari.hanae.gameup.dto.base.SuperDto;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;
import org.nejjari.hanae.gameup.mapper.base.SuperMapper;
import org.nejjari.hanae.gameup.repository.base.SuperRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract generic service providing basic CRUD operations for entities and DTOs.
 *
 * @param <K> the entity type extending SuperEntity
 * @param <V> the DTO type extending SuperDto
 * @param <T> the repository type extending SuperRepository
 * @param <M> the mapper type extending SuperMapper
 */
public abstract class SuperService<K extends SuperEntity, V extends SuperDto, T extends SuperRepository<K>, M extends SuperMapper<V, K>> {
    /**
     * The repository used for data access.
     */
    protected final T repository;

    /**
     * The mapper used for converting between DTOs and entities.
     */
    protected final M mapper;

    /**
     * Constructs a SuperService with the specified repository and mapper.
     *
     * @param repository the repository to use
     * @param mapper     the mapper to use
     */
    public SuperService(T repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Saves or updates the given DTO.
     *
     * @param dto the DTO to save or update
     * @return the saved or updated DTO
     */
    public V saveOrUpdate(V dto) {
        K entity = mapper.toEntity(dto);
        K save = repository.save(entity);
        V dto1 = mapper.toDto(save);
        return dto1;
    }

    /**
     * Saves or updates a list of DTOs.
     *
     * @param dtos the list of DTOs to save or update
     * @return the list of saved or updated DTOs
     */
    public List<V> saveOrUpdateAll(List<V> dtos) {
        List<K> entities = dtos.stream().map(mapper::toEntity).toList();
        return repository.saveAll(entities).stream().map(mapper::toDto).toList();
    }

    /**
     * Finds a DTO by its identifier.
     *
     * @param id the identifier of the entity
     * @return the found DTO
     * @throws java.util.NoSuchElementException if the entity is not found
     */
    public V findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    /**
     * Returns all DTOs.
     *
     * @return the list of all DTOs
     */
    public List<V> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Returns all DTOs matching the given list of identifiers.
     *
     * @param ids the list of identifiers
     * @return the list of matching DTOs
     */
    public List<V> findAllById(List<Long> ids) {
        return repository.findAllById(ids).stream().map(mapper::toDto).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Deletes an entity by its identifier.
     *
     * @param id the identifier of the entity to delete
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}