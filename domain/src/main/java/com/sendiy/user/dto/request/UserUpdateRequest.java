package com.sendiy.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * author: ahror
 <p>
 * since: 08/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private UUID id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
}
