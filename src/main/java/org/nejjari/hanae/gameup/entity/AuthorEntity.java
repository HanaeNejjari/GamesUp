package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Entity representing an author in the system.
 */
@Entity
@NoArgsConstructor
public class AuthorEntity extends SuperEntity {
    /**
     * The name of the author.
     */
    private String name;

    /**
     * The list of games associated with the author.
     */
    @OneToMany(fetch = FetchType.EAGER)
    private List<GameEntity> games = new ArrayList<>(0);

    /**
     * Constructs an AuthorEntity with the specified id, name, and games.
     *
     * @param id    the unique identifier
     * @param name  the author's name
     * @param games the list of games
     */
    public AuthorEntity(Long id, String name, List<GameEntity> games) {
        this.id = id;
        this.name = name;
        this.games = Optional.ofNullable(games).orElse(this.games);
    }

    /**
     * Returns the identifier of the author.
     *
     * @return the id
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the id of the author.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of the author.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the author.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the author.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the list of games.
     *
     * @return the games
     */
    public List<GameEntity> getGames() {
        return this.games;
    }

    /**
     * Sets the list of games.
     *
     * @param games the games to set
     */
    public void setGames(List<GameEntity> games) {
        this.games = games;
    }


    /**
     * Returns a string representation of the author.
     *
     * @return the string representation
     */
    public String toString() {
        return "AuthorEntity(id=" + this.getId() + ", name=" + this.getName() + ", games=" + this.getGames() + ")";
    }
}