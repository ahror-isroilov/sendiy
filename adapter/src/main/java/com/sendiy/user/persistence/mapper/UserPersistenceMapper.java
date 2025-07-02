package com.sendiy.user.persistence.mapper;

import com.sendiy.common.jooq.tables.records.UsersRecord;
import com.sendiy.user.model.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    User toDomain(UsersRecord record);
    UsersRecord toRecord(User domain);
    List<User> toDomain(List<UsersRecord> records);
    List<UsersRecord> toRecord(List<User> records);
}
