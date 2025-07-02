package com.sendiy.role.model.enums;

import com.sendiy.common.constant.PermissionConstant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * author: ahror
 *
 * <p>since: 04/10/2024
 */
@RequiredArgsConstructor
@Getter
public enum Permissions {
    ADMIN(Set.of(
            PermissionConstant.PERMISSION_ALL
    )),

    USER(Set.of(
            PermissionConstant.PERMISSION_NONE
    ));
    private final Set<String> defaultPermissions;

}
