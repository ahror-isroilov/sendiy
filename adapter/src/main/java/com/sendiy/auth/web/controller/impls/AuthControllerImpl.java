package com.sendiy.auth.web.controller.impls;

import com.sendiy.auth.dto.*;
import com.sendiy.auth.port.AuthorizationUseCase;
import com.sendiy.auth.dto.request.LoginRequest;
import com.sendiy.auth.dto.request.SetPasswordRequest;
import com.sendiy.auth.dto.request.UpdatePasswordRequest;
import com.sendiy.auth.dto.response.AccessTokenResponse;
import com.sendiy.auth.web.controller.AuthController;
import com.sendiy.common.response.GenericResponse;
import com.sendiy.otp.model.Otp;
import com.sendiy.user.dto.request.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 03/10/2024
 */
@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthorizationUseCase auth;

    @Override
    public GenericResponse<HashMap<String, Object>> register(UserCreateRequest request) {
        UUID id = auth.register(request);
        return GenericResponse.success(new HashMap<>() {{
            put("id", id);
        }});
    }

    @Override
    public GenericResponse<?> getAuthType(String phone) {
        AuthType authType = auth.getAuthType(phone);
        return GenericResponse.success(new HashMap<>() {{
            put("success", true);
            put("type", authType);
        }});
    }

    @Override
    public GenericResponse<AccessTokenResponse> login(LoginRequest request) {
        AccessTokenResponse response = auth.login(request);
        return GenericResponse.success(response);
    }

    @Override
    public GenericResponse<?> sendOtp(String phone) {
        Otp otp = auth.sendOtp(phone);
        return GenericResponse.success(otp != null);
    }

    @Override
    public GenericResponse<AccessTokenResponse> refresh(String refreshToken) {
        AccessTokenResponse token = auth.refresh(refreshToken);
        return GenericResponse.success(token);
    }

    @Override
    public GenericResponse<?> setPassword(SetPasswordRequest request) {
        auth.setPassword(request);
        return GenericResponse.success("OK");
    }

    @Override
    public GenericResponse<?> updatePassword(UpdatePasswordRequest request) {
        auth.updatePassword(request);
        return GenericResponse.success("OK");
    }

    @Override
    public GenericResponse<?> secured() {
        return GenericResponse.success("Hi");
    }
}
