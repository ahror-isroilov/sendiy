package com.sendiy.role.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleUpdateRequest {
    private Long id;
    private String name;
    private Set<String> permissions;
}
