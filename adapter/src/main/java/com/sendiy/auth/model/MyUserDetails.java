package com.sendiy.auth.model;

import com.sendiy.role.model.RoleDomain;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.UUID;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
@Getter
public class MyUserDetails implements UserDetails, Authentication {
    @Serial private static final long serialVersionUID = 1L;

    private UUID id;
    private String firstname;
    private String lastname;
    private String passwordHash;
    private String phone;
    private RoleDomain role;

    public MyUserDetails(UUID id, String firstname, String lastname, String passwordHash, String phone, RoleDomain role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.passwordHash = passwordHash;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public Object getCredentials() {
        return passwordHash;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return phone;
    }

    @Override
    public boolean isAuthenticated() {
        return id != null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissions().stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return phone;
    }
}
