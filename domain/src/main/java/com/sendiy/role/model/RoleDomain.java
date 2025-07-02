package com.sendiy.role.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * author: ahror
 *
 * <p>since: 04/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDomain {
    private Long id;
    private String name;
    private Set<String> permissions;

    public RoleDomain(String name) {
        this.name = name;
    }

    public RoleDomain(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDomain(String name, Set<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }
}
