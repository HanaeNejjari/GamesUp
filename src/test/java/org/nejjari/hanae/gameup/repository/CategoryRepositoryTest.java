package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.CategoryEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the CategoryRepository.
 * <p>
 * Verifies that CRUD operations on CategoryEntity are functioning correctly.
 * </p>
 */
public class CategoryRepositoryTest extends SuperRepositoryTest<CategoryRepository, CategoryEntity> {

    /**
     * Constructs the test class with the injected CategoryRepository.
     *
     * @param repository the CategoryRepository to be tested
     */
    @Autowired
    public CategoryRepositoryTest(CategoryRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        CategoryEntity entity = createEntity();
        entity.setType(entity.getType());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new CategoryEntity instance for testing.
     *
     * @return a new CategoryEntity with sample data
     */
    @Override
    public CategoryEntity createEntity() {
        return new CategoryEntity(null, "Action");
    }

    /**
     * Tests the full CRUD lifecycle for CategoryEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        CategoryEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setType("Action/Aventure");
        entity = repository.save(entity);
        assertEquals("Action/Aventure", entity.getType());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }

}