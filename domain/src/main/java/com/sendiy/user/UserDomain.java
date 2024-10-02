package com.sendiy.user;

import com.sendiy.user.enums.UserStatus;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDomain {
    private UUID id;
    private String firstname;
    private String lastname;
    private String passwordHash;
    private String phone;
    private UUID roleId;
    private UUID avatarId;
    private String bio;
    private UserStatus status;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime modifiedAt;
    private UUID modifiedBy;
    private LocalDateTime deletedDate;
}
