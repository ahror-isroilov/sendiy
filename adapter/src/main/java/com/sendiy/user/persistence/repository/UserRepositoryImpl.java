package com.sendiy.user.persistence.repository;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.DatabaseException;
import com.sendiy.common.exception.NotFoundException;
import com.sendiy.common.jooq.tables.records.UsersRecord;
import com.sendiy.role.model.RoleDomain;
import com.sendiy.user.dto.UserWithRole;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sendiy.common.jooq.Tables.*;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final DSLContext dsl;

    @Override
    public UUID create(UsersRecord record) {
        Record1<UUID> fetched = dsl.insertInto(USERS).set(record).returningResult(USERS.ID).fetchOne();

        if (Objects.isNull(fetched)) {
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND,
                    new HashMap<>() {{
                        put("id", record.getId());
                    }});
        }
        return fetched.get(USERS.ID);
    }

    @Override
    public UsersRecord register(UsersRecord record) {
        Record1<UsersRecord> fetched = dsl.insertInto(USERS).set(record).returningResult(USERS).fetchOne();
        if (Objects.isNull(fetched)) {
            throw new DatabaseException(ErrorMessages.DATA_INSERTION_ERROR,
                    new HashMap<>() {{
                        put("id", record.getId());
                    }});
        }
        return fetched.component1();
    }

    @Override
    public Optional<UsersRecord> get(UUID id) {
        return Optional.ofNullable(dsl.fetchOne(USERS,
                USERS.ID.eq(id)));
    }

    @Override
    public boolean exists(UUID id) {
        return dsl.fetchExists(USERS, USERS.ID.eq(id));
    }

    @Override
    public boolean existsByPhone(String phone) {
        return dsl.fetchExists(USERS, USERS.PHONE.eq(phone));
    }

    @Override
    public Optional<UsersRecord> getByPhone(String phone) {
        return Optional.ofNullable(dsl.fetchOne(USERS,
                USERS.PHONE.eq(phone)));
    }

    @Override
    public UsersRecord update(UsersRecord record) {
        Record1<UsersRecord> fetched = dsl.update(USERS)
                .set(record)
                .returningResult(USERS)
                .fetchOne();
        return Objects.requireNonNull(fetched).component1();
    }

    @Override
    public UserWithRole getUserWithRole(UUID id) {
        Stream<Record> stream = dsl.select(USERS.asterisk(), ROLES.asterisk(), ROLE_PERMISSIONS.PERMISSION)
                .from(USERS)
                .innerJoin(ROLES).on(USERS.ROLE_ID.eq(ROLES.ID))
                .innerJoin(ROLE_PERMISSIONS).on(ROLES.ID.eq(ROLE_PERMISSIONS.ROLE_ID))
                .where(USERS.ID.eq(id))
                .fetchStream();
        return stream.collect(Collectors.collectingAndThen(
                Collectors.groupingBy(
                        r -> r,
                        Collectors.mapping(r -> r.get(ROLE_PERMISSIONS.PERMISSION), Collectors.toSet())
                ),
                map -> {
                    if (map.isEmpty())
                        throw new NotFoundException(ErrorMessages.USER_NOT_FOUND,
                                new HashMap<>() {{
                                    put("id", id);
                                }});
                    Map.Entry<Record, Set<String>> entry = map.entrySet().iterator().next();
                    UserWithRole user = mapToUserWithRole(entry.getKey());
                    user.getRole().setPermissions(entry.getValue());
                    return user;
                }
        ));
    }

    @Override
    public UserWithRole getUserWithRole(String phone) {
        Stream<Record> stream = dsl.select(USERS.asterisk(), ROLES.asterisk(), ROLE_PERMISSIONS.PERMISSION)
                .from(USERS)
                .innerJoin(ROLES).on(USERS.ROLE_ID.eq(ROLES.ID))
                .innerJoin(ROLE_PERMISSIONS).on(ROLES.ID.eq(ROLE_PERMISSIONS.ROLE_ID))
                .where(USERS.PHONE.eq(phone))
                .fetchStream();
        return stream.collect(Collectors.collectingAndThen(
                Collectors.groupingBy(
                        r -> r,
                        Collectors.mapping(r -> r.get(ROLE_PERMISSIONS.PERMISSION), Collectors.toSet())
                ),
                map -> {
                    if (map.isEmpty())
                        throw new NotFoundException(ErrorMessages.USER_NOT_FOUND,
                                new HashMap<>() {{
                                    put("phone", phone);
                                }});
                    Map.Entry<Record, Set<String>> entry = map.entrySet().iterator().next();
                    UserWithRole user = mapToUserWithRole(entry.getKey());
                    user.getRole().setPermissions(entry.getValue());
                    return user;
                }
        ));
    }

    private UserWithRole mapToUserWithRole(Record record) {
        UserWithRole user = new UserWithRole();
        user.setId(record.get(USERS.ID));
        user.setFirstname(record.get(USERS.FIRSTNAME));
        user.setLastname(record.get(USERS.LASTNAME));
        user.setPasswordHash(record.get(USERS.PASSWORD_HASH));
        user.setPhone(record.get(USERS.PHONE));
        user.setAvatarId(record.get(USERS.AVATAR_ID));
        user.setRole(new RoleDomain(
                record.get(ROLES.ID),
                record.get(ROLES.NAME)
        ));
        user.setBio(record.get(USERS.BIO));
        user.setStatus(record.get(USERS.STATUS).getName());
        user.setCreatedAt(record.get(USERS.CREATED_AT));
        user.setCreatedBy(record.get(USERS.CREATED_BY));
        user.setModifiedAt(record.get(USERS.MODIFIED_AT));
        user.setModifiedBy(record.get(USERS.MODIFIED_BY));
        return user;
    }
}
