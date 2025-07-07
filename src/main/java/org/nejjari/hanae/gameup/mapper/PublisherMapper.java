package org.nejjari.hanae.gameup.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.nejjari.hanae.gameup.dto.PublisherDto;
import org.nejjari.hanae.gameup.entity.PublisherEntity;
import org.nejjari.hanae.gameup.mapper.base.SuperMapper;

/**
 * Mapper interface for converting between PublisherDto and PublisherEntity.
 * Uses MapStruct for automatic implementation generation.
 * <p>
 * This interface extends the generic SuperMapper to inherit basic mapping methods.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PublisherMapper extends SuperMapper<PublisherDto, PublisherEntity> {
}

