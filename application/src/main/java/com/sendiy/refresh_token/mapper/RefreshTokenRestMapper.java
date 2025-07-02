package com.sendiy.refresh_token.mapper;

import com.sendiy.auth.dto.response.RefreshTokenResponse;
import com.sendiy.refresh_token.model.RefreshToken;
import com.sendiy.user.mapper.UserRestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Mapper(componentModel = "spring", uses = UserRestMapper.class)
public interface RefreshTokenRestMapper {
    @Mapping(target = "user", source = "userId")
    RefreshTokenResponse toResponse(RefreshToken refreshToken);

    RefreshToken toDomain(RefreshToken refreshToken);
}
