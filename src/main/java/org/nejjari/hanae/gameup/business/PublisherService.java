package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.PublisherDto;
import org.nejjari.hanae.gameup.entity.PublisherEntity;
import org.nejjari.hanae.gameup.mapper.PublisherMapper;
import org.nejjari.hanae.gameup.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for publishers.
 * Extends the generic SuperService for PublisherEntity and PublisherDto.
 */
@Service
@Transactional
public class PublisherService extends SuperService<PublisherEntity, PublisherDto, PublisherRepository, PublisherMapper> {

    /**
     * Constructs a PublisherService with the specified repository and mapper.
     *
     * @param repository the publisher repository to use
     * @param mapper     the publisher mapper to use
     */
    @Autowired
    public PublisherService(PublisherRepository repository, PublisherMapper mapper) {
        super(repository, mapper);
    }
}