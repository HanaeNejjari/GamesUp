package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

/**
 * Entity representing a game in the system.
 */
@NoArgsConstructor
@Entity
public class GameEntity extends SuperEntity {
    /**
     * The name of the game.
     */
    private String nom;

    /**
     * The author of the game.
     */
    private String auteur;

    /**
     * The genre of the game.
     */
    private String genre;

    /**
     * The category of the game.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    /**
     * The publisher of the game.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    /**
     * The edition number of the game.
     */
    private String numEdition;

    public GameEntity(Long id, String nom, String auteur, String genre, CategoryEntity category, PublisherEntity publisher, String numEdition) {
        super.id = id;
        this.nom = nom;
        this.auteur = auteur;
        this.genre = genre;
        this.category = category;
        this.publisher = publisher;
        this.numEdition = numEdition;
    }

    /**
     * Returns the identifier of the game.
     *
     * @return the id
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public String getNumEdition() {
        return numEdition;
    }

    public void setNumEdition(String numEdition) {
        this.numEdition = numEdition;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "nom='" + nom + '\'' +
                ", auteur='" + auteur + '\'' +
                ", genre='" + genre + '\'' +
                ", category=" + category +
                ", publisher=" + publisher +
                ", numEdition='" + numEdition + '\'' +
                ", id=" + id +
                '}';
    }
}