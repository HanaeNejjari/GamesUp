package org.nejjari.hanae.gameup.repository;

import org.nejjari.hanae.gameup.entity.PublisherEntity;
import org.nejjari.hanae.gameup.repository.base.SuperRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing PublisherEntity persistence.
 * <p>
 * Extends the generic SuperRepository to inherit basic CRUD operations.
 * Annotated with @Repository to indicate it's a Spring-managed component.
 */
@Repository
public interface PublisherRepository extends SuperRepository<PublisherEntity> {
}