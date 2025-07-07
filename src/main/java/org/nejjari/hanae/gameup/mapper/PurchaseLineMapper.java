package org.nejjari.hanae.gameup.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.nejjari.hanae.gameup.dto.PurchaseLineDto;
import org.nejjari.hanae.gameup.entity.PurchaseLineEntity;
import org.nejjari.hanae.gameup.mapper.base.SuperMapper;

/**
 * Mapper interface for converting between PurchaseLineDto and PurchaseLineEntity.
 * Uses MapStruct for automatic implementation generation.
 * <p>
 * This interface extends the generic SuperMapper to inherit basic mapping methods.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PurchaseLineMapper extends SuperMapper<PurchaseLineDto, PurchaseLineEntity> {
}

