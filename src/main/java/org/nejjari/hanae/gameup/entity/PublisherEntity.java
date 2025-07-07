package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

/**
 * Entity representing a publisher in the system.
 */
@Entity
@NoArgsConstructor
public class PublisherEntity extends SuperEntity {

    /**
     * The name of the publisher.
     */
    private String name;

    /**
     * Constructs a PublisherEntity with the specified parameters.
     *
     * @param id   the unique identifier
     * @param name the name of the publisher
     */
    public PublisherEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the identifier of the publisher.
     *
     * @return the identifier
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the identifier of the publisher.
     *
     * @return the identifier
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the identifier of the publisher.
     *
     * @param id the identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the publisher.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the publisher.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PublisherEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
