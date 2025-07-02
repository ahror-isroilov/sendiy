package com.sendiy.role.persistence.repository;

import com.sendiy.common.jooq.tables.records.RolesRecord;
import com.sendiy.role.model.RoleDomain;

import java.util.Optional;
import java.util.Set;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
public interface RoleRepository {
    Long create(RolesRecord record, Set<String> permissions);

    Optional<RolesRecord> get(Long id);

    Optional<RoleDomain> getWithPermissions(Long id);

    RolesRecord update(RolesRecord record);
}
