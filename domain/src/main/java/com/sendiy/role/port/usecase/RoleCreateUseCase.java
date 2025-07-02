package com.sendiy.role.port.usecase;

import com.sendiy.role.dto.RoleCreateRequest;
import com.sendiy.role.dto.RoleResponse;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
public interface RoleCreateUseCase {
    Long create(RoleCreateRequest request);
}
