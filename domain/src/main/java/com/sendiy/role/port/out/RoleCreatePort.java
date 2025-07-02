package com.sendiy.role.port.out;

import com.sendiy.role.model.RoleDomain;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
public interface RoleCreatePort {
    Long create(RoleDomain domain);
}
