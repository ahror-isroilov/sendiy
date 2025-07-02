package com.sendiy.role.persistence.mapper;

import com.sendiy.common.jooq.tables.records.RolesRecord;
import com.sendiy.role.model.RoleDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
@Mapper(componentModel = "spring")
public interface RolePersistenceMapper {
    @Mapping(target = "permissions", ignore = true)
    RoleDomain toDomain(RolesRecord record);

    @Mapping(target = "id",ignore = true)
    RolesRecord toRecord(RoleDomain domain);

    List<RoleDomain> toDomain(List<RolesRecord> records);

    List<RolesRecord> toRecord(List<RoleDomain> records);
}
