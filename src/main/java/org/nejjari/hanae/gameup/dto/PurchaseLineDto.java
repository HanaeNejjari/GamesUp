package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;


/**
 * Data Transfer Object representing a single line in a purchase.
 * Contains the ID, user ID, game ID, and price of the purchase line.
 */
public record PurchaseLineDto(Long id, Long utilisateurId, Long jeuId, Double prix) implements SuperDto {

    /**
     * Constructs a new PurchaseLineDto with the specified details.
     *
     * @param id            the unique identifier of the purchase line
     * @param utilisateurId the ID of the user who made the purchase
     * @param jeuId         the ID of the game being purchased
     * @param prix          the price of the game
     */
    public PurchaseLineDto(Long id, Long utilisateurId, Long jeuId, Double prix) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.jeuId = jeuId;
        this.prix = prix;
    }

    /**
     * Returns the unique identifier of the purchase line.
     *
     * @return the ID of the purchase line
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}
