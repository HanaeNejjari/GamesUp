package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;


/**
 * Data Transfer Object representing a Publisher.
 * Contains the unique identifier and the name of the publisher.
 */
public record PublisherDto(Long id, String name) implements SuperDto {

    /**
     * Constructs a new PublisherDto with the specified ID and name.
     *
     * @param id   the unique identifier of the publisher
     * @param name the name of the publisher
     */
    public PublisherDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the unique identifier of the publisher.
     *
     * @return the ID of the publisher
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}

