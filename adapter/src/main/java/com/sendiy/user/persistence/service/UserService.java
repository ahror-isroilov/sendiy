package com.sendiy.user.persistence.service;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.NotFoundException;
import com.sendiy.common.jooq.tables.records.UsersRecord;
import com.sendiy.user.dto.UserWithRole;
import com.sendiy.user.model.User;
import com.sendiy.user.persistence.mapper.UserPersistenceMapper;
import com.sendiy.user.persistence.repository.UserRepository;
import com.sendiy.user.port.out.UserCreatePort;
import com.sendiy.user.port.out.UserGetPort;
import com.sendiy.user.port.out.UserUpdatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserCreatePort, UserUpdatePort, UserGetPort {
    private final UserRepository repository;
    private final UserPersistenceMapper mapper;

    @Override
    public UUID create(User domain) {
        UsersRecord record = mapper.toRecord(domain);
        return repository.create(record);
    }

    @Override
    public User update(User domain) {
        UsersRecord record = mapper.toRecord(domain);
        UsersRecord updated = repository.update(record);
        return mapper.toDomain(updated);
    }

    @Override
    public User get(UUID id) {
        Optional<UsersRecord> record = repository.get(id);
        if (record.isEmpty())
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND,
                    new HashMap<>() {{
                        put("id", id);
                    }});
        return mapper.toDomain(record.get());
    }

    @Override
    public boolean exists(UUID id) {
        return repository.exists(id);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return repository.existsByPhone(phone);
    }

    @Override
    public User getByPhone(String phone) {
        Optional<UsersRecord> record = repository.getByPhone(phone);
        if (record.isEmpty())
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND,
                    new HashMap<>() {{
                        put("phone", phone);
                    }});
        return mapper.toDomain(record.get());
    }

    @Override
    public UserWithRole getWithRole(UUID id) {
        return repository.getUserWithRole(id);
    }

    @Override
    public UserWithRole getWithRole(String phone) {
        return repository.getUserWithRole(phone);
    }
}
