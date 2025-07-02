package com.sendiy.refresh_token.mapper;

import com.sendiy.auth.dto.response.AccessTokenResponse;
import com.sendiy.refresh_token.model.AccessToken;
import org.mapstruct.Mapper;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Mapper(componentModel = "spring", uses = RefreshTokenRestMapper.class)
public interface AccessTokenTokenRestMapper {
    AccessTokenResponse toResponse(AccessToken token);
}
