package com.sendiy.auth.port;

import com.sendiy.auth.dto.*;
import com.sendiy.auth.dto.request.LoginRequest;
import com.sendiy.auth.dto.request.SetPasswordRequest;
import com.sendiy.auth.dto.request.UpdatePasswordRequest;
import com.sendiy.auth.dto.response.AccessTokenResponse;
import com.sendiy.otp.model.Otp;
import com.sendiy.user.dto.request.UserCreateRequest;

import java.util.UUID;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
public interface AuthorizationUseCase {
    AccessTokenResponse login(LoginRequest request);
    AccessTokenResponse refresh(String refreshToken);
    Otp sendOtp(String phone);
    AuthType getAuthType(String phone);
    UUID register(UserCreateRequest request);
    void setPassword(SetPasswordRequest request);
    void updatePassword(UpdatePasswordRequest request);
}
