package com.sendiy.user.persistence.repository;

import com.sendiy.common.jooq.tables.records.UsersRecord;
import com.sendiy.user.dto.UserWithRole;

import java.util.Optional;
import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
public interface UserRepository {
    UUID create(UsersRecord record);
    UsersRecord register(UsersRecord record);
    Optional<UsersRecord> get(UUID id);

    boolean exists(UUID id);

    boolean existsByPhone(String phone);
    Optional<UsersRecord> getByPhone(String phone);

    UsersRecord update(UsersRecord record);
    UserWithRole getUserWithRole(UUID id);
    UserWithRole getUserWithRole(String phone);
}
