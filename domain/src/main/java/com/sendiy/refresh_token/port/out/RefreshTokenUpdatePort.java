package com.sendiy.refresh_token.port.out;

import com.sendiy.refresh_token.model.RefreshToken;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
public interface RefreshTokenUpdatePort {
    RefreshToken update(RefreshToken refreshToken);
}
