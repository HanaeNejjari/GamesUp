package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.AvisEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the AvisRepository.
 * <p>
 * Verifies that CRUD operations on AvisEntity are functioning correctly.
 * </p>
 */
public class AvisRepositoryTest extends SuperRepositoryTest<AvisRepository, AvisEntity> {

    /**
     * Constructs the test class with the injected AvisRepository.
     *
     * @param repository the AvisRepository to be tested
     */
    @Autowired
    public AvisRepositoryTest(AvisRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        AvisEntity entity = createEntity();
        entity.setCommentaire(entity.getCommentaire());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new AvisEntity instance for testing.
     *
     * @return a new AvisEntity with sample data
     */
    @Override
    public AvisEntity createEntity() {
        return new AvisEntity(null, "Super jeu", 5);
    }

    /**
     * Tests the full CRUD lifecycle for AvisEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        AvisEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setCommentaire("Super jeu, je recommande");
        entity = repository.save(entity);
        assertEquals("Super jeu, je recommande", entity.getCommentaire());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }

}