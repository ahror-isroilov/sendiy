package com.sendiy.refresh_token.port.usecase;

import com.sendiy.auth.dto.response.RefreshTokenResponse;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
public interface RefreshTokenGetUseCase {
    RefreshTokenResponse get(String token);
}
