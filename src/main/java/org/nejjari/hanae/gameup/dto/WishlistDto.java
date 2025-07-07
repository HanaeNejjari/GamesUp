package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;

import java.util.List;


/**
 * Data Transfer Object representing a user's wishlist.
 * Contains the unique identifier and a list of wished game titles.
 */
public record WishlistDto(Long id, List<String> wishes) implements SuperDto {

    /**
     * Constructs a new WishlistDto with the specified ID and list of wishes.
     *
     * @param id     the unique identifier of the wishlist
     * @param wishes the list of game titles the user wishes for
     */
    public WishlistDto(Long id, List<String> wishes) {
        this.id = id;
        this.wishes = wishes;
    }

    /**
     * Returns the unique identifier of the wishlist.
     *
     * @return the ID of the wishlist
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}

