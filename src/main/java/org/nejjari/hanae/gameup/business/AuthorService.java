package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.AuthorDto;
import org.nejjari.hanae.gameup.entity.AuthorEntity;
import org.nejjari.hanae.gameup.mapper.AuthorMapper;
import org.nejjari.hanae.gameup.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for authors.
 * Extends the generic SuperService for AuthorEntity and AuthorDto.
 */
@Service
@Transactional
public class AuthorService extends SuperService<AuthorEntity, AuthorDto, AuthorRepository, AuthorMapper> {

    /**
     * Constructs an AuthorService with the specified repository and mapper.
     *
     * @param repository the author repository to use
     * @param mapper     the author mapper to use
     */
    @Autowired
    public AuthorService(AuthorRepository repository, AuthorMapper mapper) {
        super(repository, mapper);
    }
}