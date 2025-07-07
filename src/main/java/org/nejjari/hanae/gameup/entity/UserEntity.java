package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;
import org.nejjari.hanae.gameup.web.security.GrantedAuthorityImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Entity representing a user in the system.
 * Implements UserDetails for Spring Security integration.
 */
@Entity
@NoArgsConstructor
@Table(indexes = @Index(name = "idx_nom", columnList = "nom", unique = true))
public class UserEntity extends SuperEntity implements UserDetails {
    /**
     * The unique username of the user.
     */
    @Column(unique = true)
    private String nom;

    /**
     * The hashed password of the user.
     */
    private String motDePasseHash;

    /**
     * The list of roles assigned to the user.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>(2);

    /**
     * Constructs a UserEntity with the specified parameters.
     *
     * @param id             the unique identifier
     * @param nom            the username
     * @param motDePasseHash the hashed password
     * @param roles          the list of roles
     */
    public UserEntity(Long id, String nom, String motDePasseHash, List<String> roles) {
        this.id = id;
        this.nom = nom;
        this.motDePasseHash = motDePasseHash;
        this.roles = roles;
    }

    /**
     * Returns the authorities granted to the user.
     *
     * @return the collection of granted authorities
     */
    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(GrantedAuthorityImpl::new).toList();
    }

    /**
     * Returns the hashed password.
     *
     * @return the password hash
     */
    @Override
    @Transient
    public String getPassword() {
        return motDePasseHash;
    }

    /**
     * Returns the username.
     *
     * @return the username
     */
    @Override
    @Transient
    public String getUsername() {
        return nom;
    }

    /**
     * Returns the identifier of the user.
     *
     * @return the identifier
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the identifier of the user.
     *
     * @return the identifier
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the identifier of the user.
     *
     * @param id the identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the username.
     *
     * @return the username
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Sets the username.
     *
     * @param nom the username to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Returns the hashed password.
     *
     * @return the password hash
     */
    public String getMotDePasseHash() {
        return this.motDePasseHash;
    }

    /**
     * Sets the hashed password.
     *
     * @param motDePasseHash the password hash to set
     */
    public void setMotDePasseHash(String motDePasseHash) {
        this.motDePasseHash = motDePasseHash;
    }

    /**
     * Returns the list of roles.
     *
     * @return the list of roles
     */
    public List<String> getRoles() {
        return this.roles;
    }

    /**
     * Sets the list of roles.
     *
     * @param roles the list of roles to set
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    /**
     * Returns a string representation of the user.
     *
     * @return the string representation
     */
    public String toString() {
        return "UserEntity(id=" + this.getId() + ", nom=" + this.getNom() + ", motDePasseHash=" + this.getMotDePasseHash() + ", roles=" + this.getRoles() + ")";
    }
}