package org.nejjari.hanae.gameup.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.nejjari.hanae.gameup.dto.WishlistDto;
import org.nejjari.hanae.gameup.entity.WishlistEntity;
import org.nejjari.hanae.gameup.mapper.base.SuperMapper;

/**
 * Mapper interface for converting between WishlistDto and WishlistEntity.
 * Uses MapStruct for automatic implementation generation.
 * <p>
 * This interface extends the generic SuperMapper to inherit basic mapping methods.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WishlistMapper extends SuperMapper<WishlistDto, WishlistEntity> {
}

