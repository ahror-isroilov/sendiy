package com.sendiy.refresh_token.persistence.repository;

import com.sendiy.common.jooq.tables.records.RefreshTokensRecord;

import java.util.Optional;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
public interface RefreshTokenRepository {
    RefreshTokensRecord create(RefreshTokensRecord record);
    Optional<RefreshTokensRecord> get(String refreshToken);
    RefreshTokensRecord update(RefreshTokensRecord record);
}
