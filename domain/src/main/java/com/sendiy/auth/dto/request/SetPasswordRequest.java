package com.sendiy.auth.dto.request;

import com.sendiy.common.constant.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ahror
 * @since 30/10/2024
 */
@Getter
@AllArgsConstructor
public class SetPasswordRequest {
    @NotNull(message = ValidationMessages.PASSWORD_MANDATORY)
    @NotBlank(message = ValidationMessages.PASSWORD_MANDATORY)
    @NotEmpty(message = ValidationMessages.PASSWORD_MANDATORY)
    private String phone;

    @NotNull(message = ValidationMessages.PHONE_MANDATORY)
    @NotBlank(message = ValidationMessages.PHONE_MANDATORY)
    @NotEmpty(message = ValidationMessages.PHONE_MANDATORY)
    private String password;

    @NotNull(message = ValidationMessages.CONFIRM_PASSWORD_MANDATORY)
    @NotBlank(message = ValidationMessages.CONFIRM_PASSWORD_MANDATORY)
    @NotEmpty(message = ValidationMessages.CONFIRM_PASSWORD_MANDATORY)
    private String confirmPassword;
}
