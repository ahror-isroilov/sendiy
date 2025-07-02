package com.sendiy.role.persistence.repository;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.DatabaseException;
import com.sendiy.common.jooq.tables.records.RolesRecord;
import com.sendiy.role.model.RoleDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.sendiy.common.jooq.Tables.ROLES;
import static com.sendiy.common.jooq.Tables.ROLE_PERMISSIONS;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
@Slf4j
@Repository
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class RoleRepositoryImpl implements RoleRepository {
    private final DSLContext dsl;

    @Override
    public Long create(RolesRecord record, Set<String> permissions) {
        Record1<Long> fetched = dsl.insertInto(ROLES)
                .set(record)
                .returningResult(ROLES.ID)
                .fetchOne();

        if (Objects.isNull(fetched)) {
            log.error(ErrorMessages.DATA_INSERTION_ERROR + ": {} ", record.toString());
            throw new DatabaseException(ErrorMessages.DATA_INSERTION_ERROR);
        }

        BatchBindStep batch = dsl.batch(
                dsl.insertInto(ROLE_PERMISSIONS,
                                ROLE_PERMISSIONS.ROLE_ID,
                                ROLE_PERMISSIONS.PERMISSION)
                        .values((Long) null,
                                null));
        permissions.forEach(permission -> batch.bind(fetched.get(ROLES.ID),
                permission));
        batch.execute();
        return fetched.get(ROLES.ID);
    }

    @Override
    public Optional<RolesRecord> get(Long id) {
        return Optional.ofNullable(dsl.fetchOne(ROLES,
                ROLES.ID.eq(id)));
    }

    @Override
    public Optional<RoleDomain> getWithPermissions(Long id) {
        RoleDomain roleDomain = dsl.select(
                        ROLES.ID,
                        ROLES.NAME,
                        multiset(
                                select(ROLE_PERMISSIONS.PERMISSION)
                                        .from(ROLE_PERMISSIONS)
                                        .where(ROLE_PERMISSIONS.ROLE_ID.eq(ROLES.ID))
                        ).convertFrom(r -> r.map(Record1::value1))
                )
                .from(ROLES)
                .where(ROLES.ID.eq(id))
                .fetchOne(
                        record -> {
                            Long idl = record.get(ROLES.ID);
                            String name = record.get(ROLES.NAME);
                            @SuppressWarnings("unchecked")
                            List<String> list = (List<String>) record.get(2);
                            return new RoleDomain(idl,
                                    name,
                                    new HashSet<>(list));
                        }
                );
        return Optional.ofNullable(roleDomain);
    }

    @Override
    public RolesRecord update(RolesRecord record) {
        Record1<RolesRecord> fetched = dsl.update(ROLES)
                .set(record)
                .returningResult(ROLES)
                .fetchOne();
        return Objects.requireNonNull(fetched).component1();
    }
}
