package org.nejjari.hanae.gameup.repository;

import org.nejjari.hanae.gameup.entity.UserEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing UserEntity persistence.
 * <p>
 * Extends the generic SuperRepository to inherit basic CRUD operations.
 * Includes custom query methods for finding users by name or ID list,
 * and checking for the existence of a user by name.
 */
@Repository
public interface UserRepository extends SuperRepository<UserEntity> {

    /**
     * Finds a user by their name.
     *
     * @param nom the name of the user
     * @return the UserEntity with the specified name
     */
    UserEntity findByNom(String nom);

    /**
     * Finds a list of users by their IDs.
     *
     * @param userIds the list of user IDs
     * @return a list of UserEntity objects with matching IDs
     */
    List<UserEntity> findByIdIn(List<Long> userIds);

    /**
     * Checks if a user with the specified name exists.
     *
     * @param nom the name to check
     * @return true if a user with the name exists, false otherwise
     */
    Boolean existsByNom(String nom);
}
