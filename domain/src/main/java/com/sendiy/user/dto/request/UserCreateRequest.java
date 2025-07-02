package com.sendiy.user.dto.request;

import com.sendiy.common.constant.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * author: ahror
 * <p>
 * since: 08/10/2024
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    @NotNull(message = ValidationMessages.FIRSTNAME_MANDATORY)
    @NotBlank(message = ValidationMessages.FIRSTNAME_MANDATORY)
    @NotEmpty(message = ValidationMessages.FIRSTNAME_MANDATORY)
    private String firstname;

    private String lastname;

    @NotNull(message = ValidationMessages.PHONE_MANDATORY)
    @NotBlank(message = ValidationMessages.PHONE_MANDATORY)
    @NotEmpty(message = ValidationMessages.PHONE_MANDATORY)
    @Setter
    private String phone;

    private String email;

    private UUID avatarId;

    private String bio;
}
