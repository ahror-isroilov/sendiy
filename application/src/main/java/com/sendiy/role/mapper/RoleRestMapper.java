package com.sendiy.role.mapper;

import com.sendiy.role.dto.RoleCreateRequest;
import com.sendiy.role.dto.RoleResponse;
import com.sendiy.role.dto.RoleUpdateRequest;
import com.sendiy.role.model.RoleDomain;
import org.mapstruct.*;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
@Mapper(componentModel = "spring")
public interface RoleRestMapper {
    @Mapping(target = "id", ignore = true)
    RoleDomain toDomain(RoleCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RoleDomain toDomain(RoleUpdateRequest request, @MappingTarget RoleDomain target);

    RoleDomain toDomain(RoleResponse response);

    RoleResponse toResponse(RoleDomain domain);
}
