package com.sendiy.refresh_token.persistence.repository;

import com.sendiy.common.exception.DatabaseException;
import com.sendiy.common.jooq.tables.records.RefreshTokensRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

import static com.sendiy.common.jooq.Tables.REFRESH_TOKENS;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Repository
@RequiredArgsConstructor
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {
    private final DSLContext dsl;

    @Override
    public RefreshTokensRecord create(RefreshTokensRecord record) {
        Record1<RefreshTokensRecord> fetched = dsl.insertInto(REFRESH_TOKENS)
                .set(record)
                .returningResult(REFRESH_TOKENS)
                .fetchOne();
        if (Objects.isNull(fetched))
            throw new DatabaseException("Failed to insert Refresh Token");
        return fetched.component1();
    }

    @Override
    public Optional<RefreshTokensRecord> get(String refreshToken) {
        return Optional.ofNullable(dsl.fetchOne(REFRESH_TOKENS, REFRESH_TOKENS.TOKEN.eq(refreshToken)));
    }

    @Override
    public RefreshTokensRecord update(RefreshTokensRecord record) {
        Record1<RefreshTokensRecord> fetched = dsl.update(REFRESH_TOKENS)
                .set(record)
                .returningResult(REFRESH_TOKENS)
                .fetchOne();
        return Objects.requireNonNull(fetched).component1();
    }
}
