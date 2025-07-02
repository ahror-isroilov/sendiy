package com.sendiy.refresh_token.persistence.mapper;

import com.sendiy.common.jooq.tables.records.RefreshTokensRecord;
import com.sendiy.refresh_token.model.RefreshToken;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Mapper(componentModel = "spring")
public interface RefreshTokenPersistenceMapper {
    RefreshToken toDomain(RefreshTokensRecord record);

    RefreshTokensRecord toRecord(RefreshToken domain);

    List<RefreshTokensRecord> toRecords(Collection<RefreshToken> domains);

    List<RefreshToken> toDomains(Collection<RefreshTokensRecord> records);
}
