package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

/**
 * Entity representing a purchase line in the system.
 * A purchase line contains the user ID, game ID, and the price for a single item in a purchase.
 */
@Entity
@NoArgsConstructor
public class PurchaseLineEntity extends SuperEntity {
    /**
     * The identifier of the user who made the purchase.
     */
    private Long utilisateurId;

    /**
     * The identifier of the purchased game.
     */
    private Long jeuId;

    /**
     * The price of the purchased game.
     */
    private Double prix;

    /**
     * Constructs a PurchaseLineEntity with the specified parameters.
     *
     * @param id            the unique identifier
     * @param utilisateurId the user identifier
     * @param jeuId         the game identifier
     * @param prix          the price of the game
     */
    public PurchaseLineEntity(Long id, Long utilisateurId, Long jeuId, Double prix) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.jeuId = jeuId;
        this.prix = prix;
    }

    /**
     * Returns the identifier of the purchase line.
     *
     * @return the identifier
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the identifier of the purchase line.
     *
     * @return the identifier
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the identifier of the purchase line.
     *
     * @param id the identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the user identifier.
     *
     * @return the user identifier
     */
    public Long getUtilisateurId() {
        return this.utilisateurId;
    }

    /**
     * Sets the user identifier.
     *
     * @param utilisateurId the user identifier to set
     */
    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    /**
     * Returns the game identifier.
     *
     * @return the game identifier
     */
    public Long getJeuId() {
        return this.jeuId;
    }

    /**
     * Sets the game identifier.
     *
     * @param jeuId the game identifier to set
     */
    public void setJeuId(Long jeuId) {
        this.jeuId = jeuId;
    }

    /**
     * Returns the price of the game.
     *
     * @return the price
     */
    public Double getPrix() {
        return this.prix;
    }

    /**
     * Sets the price of the game.
     *
     * @param prix the price to set
     */
    public void setPrix(Double prix) {
        this.prix = prix;
    }


    /**
     * Returns a string representation of the purchase line.
     *
     * @return the string representation
     */
    public String toString() {
        return "PurchaseLineEntity(id=" + this.getId() + ", utilisateurId=" + this.getUtilisateurId() + ", jeuId=" + this.getJeuId() + ", prix=" + this.getPrix() + ")";
    }
}