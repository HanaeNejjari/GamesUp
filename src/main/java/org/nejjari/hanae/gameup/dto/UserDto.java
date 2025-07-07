package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;

import java.util.List;


/**
 * Data Transfer Object representing a user.
 * Contains the user's ID, name, hashed password, and assigned roles.
 */
public record UserDto(Long id, String nom, String motDePasseHash, List<String> roles) implements SuperDto {

    /**
     * Constructs a new UserDto with the specified details.
     *
     * @param id             the unique identifier of the user
     * @param nom            the name of the user
     * @param motDePasseHash the hashed password of the user
     * @param roles          the list of roles assigned to the user
     */
    public UserDto(Long id, String nom, String motDePasseHash, List<String> roles) {
        this.id = id;
        this.nom = nom;
        this.motDePasseHash = motDePasseHash;
        this.roles = roles;
    }

    /**
     * Returns the unique identifier of the user.
     *
     * @return the ID of the user
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}

