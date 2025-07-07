package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

/**
 * Entity representing a review (Avis) in the system.
 */
@Entity
@NoArgsConstructor
public class AvisEntity extends SuperEntity {
    /**
     * The comment of the review.
     */
    private String commentaire;

    /**
     * The rating of the review.
     */
    private Integer note;

    /**
     * Constructs an AvisEntity with the specified id, comment, and rating.
     *
     * @param id          the unique identifier
     * @param commentaire the comment
     * @param note        the rating
     */
    public AvisEntity(Long id, String commentaire, Integer note) {
        this.id = id;
        this.commentaire = commentaire;
        this.note = note;
    }

    /**
     * Returns the identifier of the review.
     *
     * @return the id
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the id of the review.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of the review.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the comment of the review.
     *
     * @return the comment
     */
    public String getCommentaire() {
        return this.commentaire;
    }

    /**
     * Sets the comment of the review.
     *
     * @param commentaire the comment to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * Returns the rating of the review.
     *
     * @return the rating
     */
    public Integer getNote() {
        return this.note;
    }

    /**
     * Sets the rating of the review.
     *
     * @param note the rating to set
     */
    public void setNote(Integer note) {
        this.note = note;
    }

    /**
     * Checks if this object is equal to another.
     *
     * @param o the other object
     * @return true if equal, false otherwise
     */


    /**
     * Returns a string representation of the review.
     *
     * @return the string representation
     */
    public String toString() {
        return "AvisEntity(id=" + this.getId() + ", commentaire=" + this.getCommentaire() + ", note=" + this.getNote() + ")";
    }
}