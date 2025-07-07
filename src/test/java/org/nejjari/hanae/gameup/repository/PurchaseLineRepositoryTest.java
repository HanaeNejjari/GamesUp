package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.PurchaseLineEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the PurchaseLineRepository.
 * <p>
 * Verifies that CRUD operations on PurchaseLineEntity are functioning correctly.
 * </p>
 */
public class PurchaseLineRepositoryTest extends SuperRepositoryTest<PurchaseLineRepository, PurchaseLineEntity> {

    /**
     * Constructs the test class with the injected PurchaseLineRepository.
     *
     * @param repository the PurchaseLineRepository to be tested
     */
    @Autowired
    public PurchaseLineRepositoryTest(PurchaseLineRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        PurchaseLineEntity entity = createEntity();
        entity.setPrix(entity.getPrix());
        entity.setJeuId(entity.getJeuId());
        entity.setUtilisateurId(entity.getUtilisateurId());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new PurchaseLineEntity instance for testing.
     *
     * @return a new PurchaseLineEntity with sample data
     */
    @Override
    public PurchaseLineEntity createEntity() {
        return new PurchaseLineEntity(null, 1L, 1L, 10.0);
    }

    /**
     * Tests the full CRUD lifecycle for PurchaseLineEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        PurchaseLineEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setPrix(20.0);
        entity = repository.save(entity);
        assertEquals(20.0, entity.getPrix());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }

}