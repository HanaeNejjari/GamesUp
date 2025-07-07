package org.nejjari.hanae.gameup.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.nejjari.hanae.gameup.dto.UserDto;
import org.nejjari.hanae.gameup.entity.UserEntity;
import org.nejjari.hanae.gameup.mapper.base.SuperMapper;

/**
 * Mapper interface for converting between UserDto and UserEntity.
 * Uses MapStruct for automatic implementation generation.
 * <p>
 * This interface extends the generic SuperMapper to inherit basic mapping methods.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends SuperMapper<UserDto, UserEntity> {
}

