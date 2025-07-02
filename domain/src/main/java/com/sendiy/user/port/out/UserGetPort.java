package com.sendiy.user.port.out;

import com.sendiy.user.dto.UserWithRole;
import com.sendiy.user.model.User;

import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
public interface UserGetPort {
    User get(UUID id);
    boolean exists(UUID id);
    boolean existsByPhone(String phone);
    User getByPhone(String phone);
    UserWithRole getWithRole(UUID id);
    UserWithRole getWithRole(String phone);
}
