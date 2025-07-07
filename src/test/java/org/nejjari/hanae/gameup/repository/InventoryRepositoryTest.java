package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.GameEntity;
import org.nejjari.hanae.gameup.entity.InventoryEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the InventoryRepository.
 * <p>
 * Verifies that CRUD operations on InventoryEntity are functioning correctly,
 * including interactions with GameEntity stock.
 * </p>
 */
public class InventoryRepositoryTest extends SuperRepositoryTest<InventoryRepository, InventoryEntity> {

    /**
     * Repository used to manage GameEntity instances for stock testing.
     */
    private final GameRepository gameRepository;

    /**
     * Constructs the test class with the injected InventoryRepository and GameRepository.
     *
     * @param repository     the InventoryRepository to be tested
     * @param gameRepository the GameRepository used for managing game stock
     */
    @Autowired
    public InventoryRepositoryTest(InventoryRepository repository, GameRepository gameRepository) {
        super(repository);
        this.gameRepository = gameRepository;
    }

    @Override
    @Test
    public void testAccessors() {
        InventoryEntity entity = createEntity();
        entity.setStock(entity.getStock());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new InventoryEntity instance for testing.
     *
     * @return a new InventoryEntity with empty stock
     */
    @Override
    public InventoryEntity createEntity() {
        return new InventoryEntity(null, HashMap.newHashMap(0));
    }

    /**
     * Tests the full CRUD lifecycle for InventoryEntity, including stock manipulation.
     */
    @Test
    @Override
    public void testCRUD() {
        InventoryEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        GameEntity game = new GameEntity(null, "Super Mario", "Hanae", "Action", null, null, String.valueOf(1));
        game = gameRepository.save(game);
        entity.getStock().put(game, 1);
        entity = repository.save(entity);
        assertTrue(entity.getStock().containsValue(1));
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }

}