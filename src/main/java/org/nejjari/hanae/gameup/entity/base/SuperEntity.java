/**
 * Package containing base entities for the GameUp application.
 */
package org.nejjari.hanae.gameup.entity.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Base entity class that provides common properties and methods for all entities.
 * It includes an auto-generated identifier, timestamps for creation and updates,
 * and abstract methods for getting the identifier.
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class SuperEntity {

    /**
     * Unique identifier for the entity.
     * This field is auto-generated and serves as the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    /**
     * Timestamp indicating when the entity was created.
     * This field is automatically set when the entity is persisted.
     */
    private LocalDateTime createdAt;
    /**
     * Timestamp indicating when the entity was last updated.
     * This field is automatically set when the entity is updated.
     */
    private LocalDateTime updatedAt;

    /**
     * Abstract method to get the unique identifier of the entity.
     * This method should be implemented by subclasses to return their specific identifier.
     *
     * @return the unique identifier of the entity
     */

    @Transient
    public abstract Long getIdentifier();

    /**
     * Retrieves the creation timestamp of the entity.
     *
     * @return the creation timestamp
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Retrieves the last update timestamp of the entity.
     *
     * @return the last update timestamp
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Initializes the entity with the current timestamp when it is persisted.
     */
    @PrePersist
    private void init() {
        this.createdAt = LocalDateTime.now();
        update();
    }

    /**
     * Updates the last updated timestamp of the entity when it is modified.
     */
    @PreUpdate
    private void update() {
        this.updatedAt = LocalDateTime.now();
    }


    /**
     * Retrieves the last update timestamp of the entity.
     *
     * @return the last update timestamp
     */
    public Long getId() {
        return this.id;
    }


    /**
     * Sets the unique identifier for the entity.
     *
     * @param id the unique identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }


}
