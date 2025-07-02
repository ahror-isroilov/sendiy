package com.sendiy.user.model;

import com.sendiy.user.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class User {
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

    public User() {
        this.id = UUID.randomUUID();
    }
}
