package com.sendiy.user.dto.response;

import com.sendiy.user.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UUID id;
    private String firstname;
    private String lastname;
    private String passwordHash;
    private String phone;
    private String email;
    private Long roleId;
    private UUID avatarId;
    private String bio;
    private UserStatus status;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime modifiedAt;
    private UUID modifiedBy;
    private LocalDateTime deletedDate;
}
