package com.sendiy.user.port.usecase;

import com.sendiy.user.dto.response.UserResponse;
import com.sendiy.user.dto.request.UserUpdateRequest;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
public interface UserUpdateUseCase {
    UserResponse update(UserUpdateRequest request);
}
