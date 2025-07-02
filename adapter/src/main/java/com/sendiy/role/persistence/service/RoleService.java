package com.sendiy.role.persistence.service;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.NotFoundException;
import com.sendiy.common.jooq.tables.records.RolesRecord;
import com.sendiy.role.model.RoleDomain;
import com.sendiy.role.persistence.mapper.RolePersistenceMapper;
import com.sendiy.role.persistence.repository.RoleRepository;
import com.sendiy.role.port.out.RoleCreatePort;
import com.sendiy.role.port.out.RoleGetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
@Service
@RequiredArgsConstructor
public class RoleService implements RoleCreatePort, RoleGetPort {
    private final RoleRepository roleRepository;
    private final RolePersistenceMapper roleMapper;

    @Override
    public Long create(RoleDomain domain) {
        return roleRepository.create(roleMapper.toRecord(domain),
                domain.getPermissions());
    }

    @Override
    public RoleDomain get(Long id) {
        Optional<RolesRecord> optional = roleRepository.get(id);
        if (optional.isEmpty())
            throw new NotFoundException(ErrorMessages.ROLE_NOT_FOUND,
                    new HashMap<>() {{
                        put("id", id);
                    }});
        return roleMapper.toDomain(optional.get());
    }
}
