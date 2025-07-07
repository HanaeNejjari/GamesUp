package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

/**
 * Entity representing a game category in the system.
 */
@Entity
@NoArgsConstructor
public class CategoryEntity extends SuperEntity {
    /**
     * The type of the category.
     */
    private String type;

    /**
     * Constructs a CategoryEntity with the specified id and type.
     *
     * @param id   the unique identifier
     * @param type the type of the category
     */
    public CategoryEntity(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    /**
     * Returns the identifier of the category.
     *
     * @return the id
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the id of the category.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of the category.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the type of the category.
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of the category.
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * Returns a string representation of the category.
     *
     * @return the string representation
     */
    public String toString() {
        return "CategoryEntity(id=" + this.getId() + ", type=" + this.getType() + ")";
    }
}