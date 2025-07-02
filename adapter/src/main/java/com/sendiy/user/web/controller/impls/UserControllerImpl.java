package com.sendiy.user.web.controller.impls;

import com.sendiy.common.response.GenericResponse;
import com.sendiy.user.dto.request.UserCreateRequest;
import com.sendiy.user.dto.response.UserResponse;
import com.sendiy.user.port.usecase.UserCreateUseCase;
import com.sendiy.user.port.usecase.UserGetUseCase;
import com.sendiy.user.web.controller.UserController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserCreateUseCase userCreateUseCase;
    private final UserGetUseCase userGetUseCase;

    @Override
    public GenericResponse<UUID> register(UserCreateRequest request) {
        UUID uuid = userCreateUseCase.create(request);
        return GenericResponse.success(uuid);
    }

    @Override
    public GenericResponse<UserResponse> get(UUID id) {
        UserResponse response = userGetUseCase.get(id);
        return GenericResponse.success(response);
    }

    @Override
    public GenericResponse<?> getDetailed(UUID id, boolean role, boolean avatar) {
        Object response;
        if (role && avatar)
            response = userGetUseCase.getFull(id);
        else if (avatar) response = userGetUseCase.getWithAvatar(id);
        else if (role) response = userGetUseCase.getWithRole(id);
        else response = userGetUseCase.get(id);
        return GenericResponse.success(response);
    }
}
