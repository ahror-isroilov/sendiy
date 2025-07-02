package com.sendiy.user.port.usecase;



import com.sendiy.user.dto.request.UserCreateRequest;

import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
public interface UserCreateUseCase {
        UUID create(UserCreateRequest request);
}
