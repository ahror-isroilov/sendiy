package com.sendiy.user.port.usecase;

import com.sendiy.user.dto.UserFull;
import com.sendiy.user.dto.response.UserResponse;
import com.sendiy.user.dto.UserWithRole;

import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
public interface UserGetUseCase {
    UserResponse get(UUID id);
    UserWithRole getWithRole(UUID id);
    UserWithRole getWithAvatar(UUID id);
    UserFull getFull(UUID id);
}
