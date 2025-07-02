package com.sendiy.file.persistence.mapper;

import com.sendiy.common.jooq.tables.records.FilesRecord;
import com.sendiy.file.model.FileDomain;
import org.mapstruct.Mapper;

/**
 * @author ahror
 * @since 05/11/2024
 */
@Mapper(componentModel = "spring")
public interface FilePersistenceMapper {
    FilesRecord toRecord(FileDomain domain);

    FileDomain toDomain(FilesRecord record);
}
