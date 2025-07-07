package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.CategoryDto;
import org.nejjari.hanae.gameup.entity.CategoryEntity;
import org.nejjari.hanae.gameup.mapper.CategoryMapper;
import org.nejjari.hanae.gameup.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for categories.
 * Extends the generic SuperService for CategoryEntity and CategoryDto.
 */
@Service
@Transactional
public class CategoryService extends SuperService<CategoryEntity, CategoryDto, CategoryRepository, CategoryMapper> {

    /**
     * Constructs a CategoryService with the specified repository and mapper.
     *
     * @param repository the category repository to use
     * @param mapper     the category mapper to use
     */
    @Autowired
    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }
}