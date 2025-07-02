package com.sendiy.role.port.out;

import com.sendiy.role.model.RoleDomain;

import javax.management.relation.Role;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
public interface RoleUpdatePort {
    void updateRole(RoleDomain domain);
}
