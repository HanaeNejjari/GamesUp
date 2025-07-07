package org.nejjari.hanae.gameup.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.nejjari.hanae.gameup.dto.CategoryDto;
import org.nejjari.hanae.gameup.entity.CategoryEntity;
import org.nejjari.hanae.gameup.mapper.base.SuperMapper;

/**
 * Mapper interface for converting between CategoryDto and CategoryEntity.
 * Uses MapStruct for automatic implementation generation.
 * <p>
 * This interface extends the generic SuperMapper to inherit basic mapping methods.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper extends SuperMapper<CategoryDto, CategoryEntity> {
}

