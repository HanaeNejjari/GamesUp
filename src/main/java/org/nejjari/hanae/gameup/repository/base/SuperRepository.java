package org.nejjari.hanae.gameup.repository.base;

import org.nejjari.hanae.gameup.entity.base.SuperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Generic repository interface for entities extending SuperEntity.
 * <p>
 * This interface extends Spring Data JPA's JpaRepository to provide
 * basic CRUD operations for any entity type that extends SuperEntity.
 *
 * @param <T> the type of the entity, which must extend {@link SuperEntity}
 */
public interface SuperRepository<T extends SuperEntity> extends JpaRepository<T, Long> {
}

