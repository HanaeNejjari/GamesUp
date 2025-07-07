package org.nejjari.hanae.gameup.repository;

import org.junit.jupiter.api.Test;
import org.nejjari.hanae.gameup.entity.GameEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the GameRepository.
 * <p>
 * Verifies that CRUD operations on GameEntity are functioning correctly.
 * </p>
 */
public class GameRepositoryTest extends SuperRepositoryTest<GameRepository, GameEntity> {

    /**
     * Constructs the test class with the injected GameRepository.
     *
     * @param repository the GameRepository to be tested
     */
    @Autowired
    public GameRepositoryTest(GameRepository repository) {
        super(repository);
    }

    @Override
    @Test
    public void testAccessors() {
        GameEntity entity = createEntity();
        entity.setGenre(entity.getGenre());
        entity.setAuteur(entity.getAuteur());
        entity.setNom(entity.getNom());
        entity.setNumEdition(entity.getNumEdition());
        entity.setPublisher(entity.getPublisher());
        entity.setCategory(entity.getCategory());
        entity.setId(entity.getId());
        entity.toString();
    }

    /**
     * Creates a new GameEntity instance for testing.
     *
     * @return a new GameEntity with sample data
     */
    @Override
    public GameEntity createEntity() {
        return new GameEntity(null, "Super Mario", "Hanae", "Action", null, null, String.valueOf(1));
    }

    /**
     * Tests the full CRUD lifecycle for GameEntity.
     */
    @Test
    @Override
    public void testCRUD() {
        GameEntity entity = createEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getIdentifier());
        assertTrue(repository.existsById(entity.getIdentifier()));
        entity.setGenre("Action/Aventure");
        entity = repository.save(entity);
        assertEquals("Action/Aventure", entity.getGenre());
        repository.delete(entity);
        assertFalse(repository.findById(entity.getIdentifier()).isPresent());
    }


}