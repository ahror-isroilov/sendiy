package com.sendiy.file.persistence.repository;

import com.sendiy.common.jooq.tables.records.FilesRecord;

import java.util.Optional;
import java.util.UUID;

/**
 * @author ahror
 * @since 05/11/2024
 */

public interface FileRepository {
    UUID save(FilesRecord record);

    Optional<FilesRecord> get(UUID id);
}
