package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;

import java.util.Map;

/**
 * Data Transfer Object representing an inventory.
 * Contains the inventory ID and a map of games with their stock quantities.
 *
 * @param id    the unique identifier of the inventory
 * @param stock a map where the key is a GameDto and the value is the quantity in stock
 */
public record InventoryDto(Long id, Map<GameDto, Integer> stock) implements SuperDto {

    public InventoryDto(Long id, Map<GameDto, Integer> stock) {
        this.id = id;
        this.stock = stock;
    }

    /**
     * Returns the unique identifier of the inventory.
     *
     * @return the inventory ID
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}
