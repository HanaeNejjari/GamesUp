package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.PublisherEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the PublisherRepository.
 * <p>
 * Verifies that CRUD operations on PublisherEntity are functioning correctly.
 * </p>
 */
public class PublisherRepositoryTest extends SuperRepositoryTest<PublisherRepository, PublisherEntity> {

    /**
     * Constructs the test class with the injected PublisherRepository.
     *
     * @param repository the PublisherRepository to be tested
     */
    @Autowired
    public PublisherRepositoryTest(PublisherRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        PublisherEntity entity = createEntity();
        entity.setName(entity.getName());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new PublisherEntity instance for testing.
     *
     * @return a new PublisherEntity with sample data
     */
    @Override
    public PublisherEntity createEntity() {
        return new PublisherEntity(null, "Hanae");
    }

    /**
     * Tests the full CRUD lifecycle for PublisherEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        PublisherEntity entity = createEntity();
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