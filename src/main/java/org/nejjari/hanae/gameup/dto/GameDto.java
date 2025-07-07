package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;

/**
 * Data Transfer Object representing a game.
 * Contains details such as name, author, genre, category, publisher, and edition number.
 *
 * @param id         the unique identifier of the game
 * @param nom        the name of the game
 * @param auteur     the author or creator of the game
 * @param genre      the genre of the game
 * @param category   the category to which the game belongs
 * @param publisher  the publisher of the game
 * @param numEdition the edition number of the game
 */
public record GameDto(
        Long id,
        String nom,
        String auteur,
        String genre,
        CategoryDto category,
        PublisherDto publisher,
        String numEdition
) implements SuperDto {

    public GameDto(Long id, String nom, String auteur, String genre, CategoryDto category, PublisherDto publisher, String numEdition) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
        this.genre = genre;
        this.category = category;
        this.publisher = publisher;
        this.numEdition = numEdition;
    }

    /**
     * Returns the unique identifier of the game.
     *
     * @return the game ID
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}
