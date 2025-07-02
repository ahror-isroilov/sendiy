package com.sendiy.user.mapper;

import com.sendiy.user.dto.request.UserCreateRequest;
import com.sendiy.user.dto.response.UserResponse;
import com.sendiy.user.dto.response.UserShortResponse;
import com.sendiy.user.dto.request.UserUpdateRequest;
import com.sendiy.user.model.User;
import com.sendiy.user.port.out.UserGetPort;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
@Mapper(componentModel = "spring")
public abstract class UserRestMapper {
    @Autowired
    private UserGetPort userGetPort;

    public abstract User toDomain(UserCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract User toDomain(UserUpdateRequest request, @MappingTarget User target);

    public abstract User toDomain(UserResponse response);

    public abstract UserResponse toResponse(User domain);

    public abstract UserShortResponse toShortResponse(User domain);

    public UserShortResponse toShortResponse(UUID id) {
        User user = userGetPort.get(id);
        return toShortResponse(user);
    }
}
