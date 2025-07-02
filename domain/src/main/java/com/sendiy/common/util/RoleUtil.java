package com.sendiy.common.util;

import com.sendiy.role.model.RoleDomain;
import com.sendiy.role.model.enums.Permissions;

/**
 * author: ahror
 * <p>
 * since: 10/10/2024
 */
public final class RoleUtil {
    public static RoleDomain createUserRole() {
        RoleDomain role = new RoleDomain();
        role.setName(Permissions.USER.name());
        role.setPermissions(Permissions.USER.getDefaultPermissions());
        return role;
    }
}
