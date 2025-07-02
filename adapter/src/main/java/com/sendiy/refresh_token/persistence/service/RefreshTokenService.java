package com.sendiy.refresh_token.persistence.service;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.NotFoundException;
import com.sendiy.common.jooq.tables.records.RefreshTokensRecord;
import com.sendiy.refresh_token.model.RefreshToken;
import com.sendiy.refresh_token.persistence.mapper.RefreshTokenPersistenceMapper;
import com.sendiy.refresh_token.persistence.repository.RefreshTokenRepository;
import com.sendiy.refresh_token.port.out.RefreshTokenCreatePort;
import com.sendiy.refresh_token.port.out.RefreshTokenGetPort;
import com.sendiy.refresh_token.port.out.RefreshTokenUpdatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Service
@RequiredArgsConstructor
public class RefreshTokenService implements RefreshTokenCreatePort, RefreshTokenGetPort, RefreshTokenUpdatePort {
    private final RefreshTokenRepository repository;
    private final RefreshTokenPersistenceMapper mapper;

    @Override
    public RefreshToken create(RefreshToken refreshToken) {
        RefreshTokensRecord record = mapper.toRecord(refreshToken);
        return mapper.toDomain(repository.create(record));
    }

    @Override
    public RefreshToken get(String token) {
        Optional<RefreshTokensRecord> optional = repository.get(token);
        if (optional.isEmpty())
            throw new NotFoundException(ErrorMessages.REFRESH_TOKEN_NOT_FOUND, new HashMap<>() {{
                put("token", token);
            }});
        return mapper.toDomain(optional.get());
    }

    @Override
    public RefreshToken update(RefreshToken refreshToken) {
        RefreshTokensRecord record = mapper.toRecord(refreshToken);
        RefreshTokensRecord updated = repository.update(record);
        return mapper.toDomain(updated);
    }
}