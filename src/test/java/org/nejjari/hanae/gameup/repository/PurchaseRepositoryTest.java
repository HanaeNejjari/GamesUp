package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.PurchaseEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the PurchaseRepository.
 * <p>
 * Verifies that CRUD operations on PurchaseEntity are functioning correctly.
 * </p>
 */
public class PurchaseRepositoryTest extends SuperRepositoryTest<PurchaseRepository, PurchaseEntity> {

    /**
     * Constructs the test class with the injected PurchaseRepository.
     *
     * @param repository the PurchaseRepository to be tested
     */
    @Autowired
    public PurchaseRepositoryTest(PurchaseRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        PurchaseEntity entity = createEntity();
        entity.setArchived(entity.isArchived());
        entity.setDate(entity.getDate());
        entity.setDelivered(entity.isDelivered());
        entity.setLine(entity.getLine());
        entity.setPaid(entity.isPaid());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new PurchaseEntity instance for testing.
     *
     * @return a new PurchaseEntity with sample data
     */
    @Override
    public PurchaseEntity createEntity() {
        return new PurchaseEntity(null, Collections.emptyList(), LocalDate.now(), true, false, true);
    }

    /**
     * Tests the full CRUD lifecycle for PurchaseEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        PurchaseEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setArchived(true);
        entity = repository.save(entity);
        assertTrue(entity.isArchived());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }

}