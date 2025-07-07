package org.nejjari.hanae.gameup.web.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Implementation of the GrantedAuthority interface.
 * <p>
 * This class represents a simple authority granted to a user, typically a role.
 * </p>
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    /**
     * The authority granted to the user (e.g., ROLE_USER, ROLE_ADMIN).
     * This field is used by Spring Security to determine access rights.
     */
    private final String authority;

    /**
     * Constructs a GrantedAuthorityImpl with the specified authority string.
     *
     * @param authority the authority granted to the user (e.g., ROLE_USER, ROLE_ADMIN)
     */
    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    /**
     * Returns the authority granted to the user.
     *
     * @return the authority string
     */
    @Override
    public String getAuthority() {
        return authority;
    }
}
