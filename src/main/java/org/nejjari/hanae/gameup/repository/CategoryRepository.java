package org.nejjari.hanae.gameup.repository;

import org.nejjari.hanae.gameup.entity.CategoryEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing CategoryEntity persistence.
 * <p>
 * Extends the generic SuperRepository to inherit basic CRUD operations.
 * Annotated with @Repository to indicate it's a Spring-managed component.
 */
@Repository
public interface CategoryRepository extends SuperRepository<CategoryEntity> {
}

