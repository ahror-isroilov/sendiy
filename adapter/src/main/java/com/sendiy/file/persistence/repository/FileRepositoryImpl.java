package com.sendiy.file.persistence.repository;

import com.sendiy.common.jooq.Tables;
import com.sendiy.common.jooq.tables.records.FilesRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author ahror
 * @since 05/11/2024
 */
@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository {
    private final DSLContext dsl;

    @Override
    public UUID save(FilesRecord record) {
        Record1<UUID> fetched = dsl.insertInto(Tables.FILES).set(record)
                .returningResult(Tables.FILES.ID).fetchOne();
        if (fetched != null) return fetched.component1();
        else return null;
    }

    @Override
    public Optional<FilesRecord> get(UUID id) {
        FilesRecord record = dsl.fetchOne(Tables.FILES, Tables.FILES.ID.eq(id));
        return Optional.ofNullable(record);
    }
}
