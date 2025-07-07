package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Entity representing a game inventory in the system.
 * The inventory contains an association between each game and its stock quantity.
 */
@Entity
@NoArgsConstructor
public class InventoryEntity extends SuperEntity {
    /**
     * Stock of games, associating each game with its available quantity.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<GameEntity, Integer> stock = new HashMap<>(0);

    /**
     * Constructs an InventoryEntity with the specified parameters.
     *
     * @param id    the unique identifier of the inventory
     * @param stock the stock of games (game, quantity)
     */
    public InventoryEntity(Long id, Map<GameEntity, Integer> stock) {
        this.id = id;
        this.stock = Optional.ofNullable(stock).orElse(this.stock);
    }

    /**
     * Returns the identifier of the inventory.
     *
     * @return the identifier
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the identifier of the inventory.
     *
     * @return the identifier
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the identifier of the inventory.
     *
     * @param id the identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the stock of games.
     *
     * @return the map of games and quantities
     */
    public Map<GameEntity, Integer> getStock() {
        return this.stock;
    }

    /**
     * Sets the stock of games.
     *
     * @param stock the map of games and quantities to set
     */
    public void setStock(Map<GameEntity, Integer> stock) {
        this.stock = stock;
    }


    /**
     * Returns a string representation of the inventory.
     *
     * @return the string representation
     */
    public String toString() {
        return "InventoryEntity(id=" + this.getId() + ", stock=" + this.getStock() + ")";
    }
}