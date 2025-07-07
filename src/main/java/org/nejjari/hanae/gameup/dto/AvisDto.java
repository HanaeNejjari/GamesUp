package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;

/**
 * Data Transfer Object (DTO) representing a review (Avis) in the GameUp application.
 * Contains the review's unique identifier, comment, and rating.
 */
public record AvisDto(Long id, String commentaire, Integer note) implements SuperDto {
    /**
     * Constructs an AvisDto with the specified id, comment, and rating.
     *
     * @param id          the unique identifier of the review
     * @param commentaire the comment of the review
     * @param note        the rating of the review
     */
    public AvisDto(Long id, String commentaire, Integer note) {
        this.id = id;
        this.commentaire = commentaire;
        this.note = note;
    }

    /**
     * Returns the unique identifier of the review.
     *
     * @return the identifier as a {@link Long}
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}