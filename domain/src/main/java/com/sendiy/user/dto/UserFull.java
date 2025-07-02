package com.sendiy.user.dto;

import com.sendiy.role.model.RoleDomain;
import com.sendiy.user.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * author: ahror
 * <p>
 * since: 09/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFull {
    private UUID id;
    private String firstname;
    private String lastname;
    private String passwordHash;
    private String phone;
    private String email;
    private RoleDomain role;
    private UUID avatarId;
    private String bio;
    private String status;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime modifiedAt;
    private UUID modifiedBy;
    private LocalDateTime deletedDate;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatus(UserStatus status) {
        this.status = status.name();
    }
}
