package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.UserEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the UserRepository.
 * <p>
 * Verifies that CRUD operations and custom queries on UserEntity are functioning correctly.
 * </p>
 */
public class UserRepositoryTest extends SuperRepositoryTest<UserRepository, UserEntity> {

    /**
     * Constructs the test class with the injected UserRepository.
     *
     * @param repository the UserRepository to be tested
     */
    @Autowired
    public UserRepositoryTest(UserRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        UserEntity entity = createEntity();
        entity.setNom(entity.getNom());
        entity.setMotDePasseHash(entity.getMotDePasseHash());
        entity.setRoles(entity.getRoles());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new UserEntity instance for testing.
     *
     * @return a new UserEntity with sample data
     */
    @Override
    public UserEntity createEntity() {
        return new UserEntity(null, "Hanae", "Nejjari", List.of("ADMIN", "USER"));
    }

    /**
     * Tests the full CRUD lifecycle for UserEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        UserEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setNom("Hanae Nejjari");
        entity = repository.save(entity);
        assertEquals("Hanae Nejjari", entity.getNom());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }

    /**
     * Tests the custom repository method for finding a user by name.
     */
    @Test
    void findByNom() {
        if (repository.findByNom("Hanae") == null) {
            UserEntity entity = createEntity();
            repository.save(entity);
        }
        assertNotNull(repository.findByNom("Hanae"));
    }

    /**
     * Tests the custom repository method for finding users by a list of IDs.
     */
    @Test
    void findByIdIn() {
        UserEntity entity = createEntity();
        entity = repository.save(entity);
        assertFalse(repository.findByIdIn(List.of(entity.getIdentifier())).isEmpty());
    }

    /**
     * Tests the custom repository method for checking existence by name.
     */
    @Test
    void existsByNom() {
        if (repository.findByNom("Hanae") == null) {
            UserEntity entity = createEntity();
            repository.save(entity);
        }
        assertTrue(repository.existsByNom("Hanae"));
    }
}