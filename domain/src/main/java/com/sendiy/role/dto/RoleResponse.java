package com.sendiy.role.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
@Setter
@AllArgsConstructor
public class RoleResponse {
    private Long id;
    private String name;
    private Set<String> permissions;
}
