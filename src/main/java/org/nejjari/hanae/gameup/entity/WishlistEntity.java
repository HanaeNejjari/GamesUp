package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Entity representing a wishlist in the system.
 * A wishlist contains a list of wished game names.
 */
@Entity
@NoArgsConstructor
public class WishlistEntity extends SuperEntity {
    /**
     * The list of wished game names.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> wishes = new ArrayList<>(0);

    /**
     * Constructs a WishlistEntity with the specified parameters.
     *
     * @param id     the unique identifier
     * @param wishes the list of wished game names
     */
    public WishlistEntity(Long id, List<String> wishes) {
        this.id = id;
        this.wishes = Optional.ofNullable(wishes).orElse(this.wishes);
    }

    /**
     * Returns the identifier of the wishlist.
     *
     * @return the identifier
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the identifier of the wishlist.
     *
     * @return the identifier
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the identifier of the wishlist.
     *
     * @param id the identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the list of wished game names.
     *
     * @return the list of wishes
     */
    public List<String> getWishes() {
        return this.wishes;
    }

    /**
     * Sets the list of wished game names.
     *
     * @param wishes the list of wishes to set
     */
    public void setWishes(List<String> wishes) {
        this.wishes = wishes;
    }


    /**
     * Returns a string representation of the wishlist.
     *
     * @return the string representation
     */
    public String toString() {
        return "WishlistEntity(id=" + this.getId() + ", wishes=" + this.getWishes() + ")";
    }
}