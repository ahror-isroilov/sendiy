package com.sendiy.user.usecase;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.BadCredentialsException;
import com.sendiy.common.exception.UserAlreadyExistsException;
import com.sendiy.common.util.BaseUtil;
import com.sendiy.common.util.RegexUtil;
import com.sendiy.role.model.RoleDomain;
import com.sendiy.role.model.enums.Permissions;
import com.sendiy.role.port.out.RoleCreatePort;
import com.sendiy.user.dto.*;
import com.sendiy.user.dto.request.UserCreateRequest;
import com.sendiy.user.dto.request.UserUpdateRequest;
import com.sendiy.user.dto.response.UserResponse;
import com.sendiy.user.mapper.UserRestMapper;
import com.sendiy.user.model.User;
import com.sendiy.user.model.enums.UserStatus;
import com.sendiy.user.port.out.UserCreatePort;
import com.sendiy.user.port.out.UserGetPort;
import com.sendiy.user.port.usecase.UserCreateUseCase;
import com.sendiy.user.port.usecase.UserGetUseCase;
import com.sendiy.user.port.usecase.UserUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * author: ahror
 * <p>
 * since: 11/10/2024
 */
@Service
@RequiredArgsConstructor
public class UserUserCase implements UserCreateUseCase, UserUpdateUseCase, UserGetUseCase {
    private final UserGetPort userGetPort;
    private final UserCreatePort userCreatePort;
    private final UserRestMapper userRestMapper;

    private final RoleCreatePort roleCreatePort;


    @Override
    public UUID create(UserCreateRequest request) {
        if (RegexUtil.isValidPhone(request.getPhone())) {
            request.setPhone(BaseUtil.formatPhone(request.getPhone()));
            if (userGetPort.existsByPhone(request.getPhone()))
                throw new UserAlreadyExistsException(new HashMap<>() {{
                    put("phone", request.getPhone());
                }});
            Long roleId = roleCreatePort.create(new RoleDomain(
                    Permissions.USER.name(),
                    Permissions.USER.getDefaultPermissions()
            ));
            User domain = userRestMapper.toDomain(request);
            domain.setStatus(UserStatus.ACTIVE);
            domain.setRoleId(roleId);
            return userCreatePort.create(domain);
        } else throw new BadCredentialsException(ErrorMessages.INVALID_PHONE_NUMBER);
    }

    @Override
    public UserResponse get(UUID id) {
        User user = userGetPort.get(id);
        return userRestMapper.toResponse(user);
    }

    @Override
    public UserWithRole getWithRole(UUID id) {
        return userGetPort.getWithRole(id);
    }

    @Override
    public UserWithRole getWithAvatar(UUID id) {
        return null;
    }

    @Override
    public UserFull getFull(UUID id) {
        return null;
    }

    @Override
    public UserResponse update(UserUpdateRequest request) {
        return null;
    }
}
