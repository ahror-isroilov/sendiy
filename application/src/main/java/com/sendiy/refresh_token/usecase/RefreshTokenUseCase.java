package com.sendiy.refresh_token.usecase;

import com.sendiy.auth.dto.response.RefreshTokenResponse;
import com.sendiy.refresh_token.mapper.RefreshTokenRestMapper;
import com.sendiy.refresh_token.model.RefreshToken;
import com.sendiy.refresh_token.port.out.RefreshTokenGetPort;
import com.sendiy.refresh_token.port.usecase.RefreshTokenGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Service
@RequiredArgsConstructor
public class RefreshTokenUseCase implements RefreshTokenGetUseCase{
    private final RefreshTokenGetPort getPort;
    private final RefreshTokenRestMapper mapper;

    @Override
    public RefreshTokenResponse get(String token) {
        RefreshToken refreshToken = getPort.get(token);
        return mapper.toResponse(refreshToken);
    }
}
