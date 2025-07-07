package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;

/**
 * Data Transfer Object representing a game category.
 * Contains the unique identifier and the type of the category.
 *
 * @param id   the unique identifier of the category
 * @param type the type or name of the category
 */
public record CategoryDto(Long id, String type) implements SuperDto {

    public CategoryDto(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    /**
     * Returns the unique identifier of the category.
     *
     * @return the category ID
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}
