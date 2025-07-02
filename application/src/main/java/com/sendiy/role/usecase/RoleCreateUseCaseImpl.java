package com.sendiy.role.usecase;

import com.sendiy.role.dto.RoleCreateRequest;
import com.sendiy.role.mapper.RoleRestMapper;
import com.sendiy.role.model.RoleDomain;
import com.sendiy.role.port.out.RoleCreatePort;
import com.sendiy.role.port.usecase.RoleCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
@Service
@RequiredArgsConstructor
public class RoleCreateUseCaseImpl implements RoleCreateUseCase {
    private final RoleCreatePort roleCreatePort;
    private final RoleRestMapper roleRestMapper;

    @Override
    public Long create(RoleCreateRequest request) {
        RoleDomain domain = roleRestMapper.toDomain(request);
        return roleCreatePort.create(domain);
    }
}

