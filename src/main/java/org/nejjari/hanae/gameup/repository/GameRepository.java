package org.nejjari.hanae.gameup.repository;

import org.nejjari.hanae.gameup.entity.GameEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Repository interface for managing GameEntity persistence.
 * <p>
 * Extends the generic SuperRepository to inherit basic CRUD operations.
 * Includes a custom query method for performing a distinct search
 * across multiple fields including name, genre, edition number, author,
 * category type, and publisher name.
 */
@Repository
public interface GameRepository extends SuperRepository<GameEntity> {

    /**
     * Performs a distinct search on multiple fields of the GameEntity and its related entities.
     *
     * @param nom           the name of the game
     * @param genre         the genre of the game
     * @param numEdition    the edition number of the game
     * @param auteur        the author of the game
     * @param categoryType  the type of the category
     * @param publisherName the name of the publisher
     * @return a set of distinct GameEntity objects matching the search criteria
     */
    @Query("""
                select distinct g from GameEntity g
                left join g.category c
                left join g.publisher p
                where upper(g.nom) like upper(concat('%', ?1, '%'))
                   or upper(g.genre) like upper(concat('%', ?2, '%'))
                   or upper(g.numEdition) like upper(concat('%', ?3, '%'))
                   or upper(g.auteur) like upper(concat('%', ?4, '%'))
                   or upper(c.type) like upper(concat('%', ?5, '%'))
                   or upper(p.name) like upper(concat('%', ?6, '%'))
            """)
    Set<GameEntity> distinctSearchByNomOrGenreOrNumEditionOrAuteurOrCategoryTypeOrPublisherName(
            String nom,
            String genre,
            String numEdition,
            String auteur,
            String categoryType,
            String publisherName
    );
}

