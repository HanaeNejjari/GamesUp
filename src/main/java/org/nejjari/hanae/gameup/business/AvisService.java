package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.AvisDto;
import org.nejjari.hanae.gameup.entity.AvisEntity;
import org.nejjari.hanae.gameup.mapper.AvisMapper;
import org.nejjari.hanae.gameup.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for reviews.
 * Extends the generic SuperService for AvisEntity and AvisDto.
 */
@Service
@Transactional
public class AvisService extends SuperService<AvisEntity, AvisDto, AvisRepository, AvisMapper> {

    /**
     * Constructs an AvisService with the specified repository and mapper.
     *
     * @param repository the review repository to use
     * @param mapper     the review mapper to use
     */
    @Autowired
    public AvisService(AvisRepository repository, AvisMapper mapper) {
        super(repository, mapper);
    }
}