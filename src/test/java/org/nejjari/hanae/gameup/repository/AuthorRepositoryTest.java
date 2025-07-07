package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.AuthorEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the AuthorRepository.
 * <p>
 * Verifies that CRUD operations on AuthorEntity are functioning correctly.
 * </p>
 */
public class AuthorRepositoryTest extends SuperRepositoryTest<AuthorRepository, AuthorEntity> {

    /**
     * Constructs the test class with the injected AuthorRepository.
     *
     * @param repository the AuthorRepository to be tested
     */
    @Autowired
    public AuthorRepositoryTest(AuthorRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        AuthorEntity entity = createEntity();
        entity.setGames(entity.getGames());
        entity.setId(entity.getId());
        entity.setGames(entity.getGames());
        entity.toString();
    }

    /**
     * Creates a new AuthorEntity instance for testing.
     *
     * @return a new AuthorEntity with sample data
     */
    @Override
    public AuthorEntity createEntity() {
        return new AuthorEntity(null, "Hanae", Collections.emptyList());
    }

    /**
     * Tests the full CRUD lifecycle for AuthorEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        AuthorEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setName("Hanae Nejjari");
        entity = repository.save(entity);
        assertEquals("Hanae Nejjari", entity.getName());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }

}