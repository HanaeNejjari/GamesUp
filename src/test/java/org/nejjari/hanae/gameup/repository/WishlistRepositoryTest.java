package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.WishlistEntity;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the WishlistRepository.
 * <p>
 * Verifies that CRUD operations on WishlistEntity are functioning correctly.
 * </p>
 */
public class WishlistRepositoryTest extends SuperRepositoryTest<WishlistRepository, WishlistEntity> {

    /**
     * Constructs the test class with the injected WishlistRepository.
     *
     * @param repository the WishlistRepository to be tested
     */
    @Autowired
    public WishlistRepositoryTest(WishlistRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        WishlistEntity entity = createEntity();
        entity.setWishes(entity.getWishes());
        entity.toString();
        entity.setId(entity.getId());
        entity.getCreatedAt();
        entity.getUpdatedAt();
        SuperEntity superEntity = entity;
        superEntity.setId(entity.getId());
    }

    /**
     * Creates a new WishlistEntity instance for testing.
     *
     * @return a new WishlistEntity with sample data
     */
    @Override
    public WishlistEntity createEntity() {
        return new WishlistEntity(null, List.of("Hanae"));
    }

    /**
     * Tests the full CRUD lifecycle for WishlistEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        WishlistEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setWishes(List.of("Hanae Nejjari"));
        entity = repository.save(entity);
        assertEquals("Hanae Nejjari", entity.getWishes().getFirst());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }
}