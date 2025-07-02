package com.sendiy.auth.web.controller;

import com.sendiy.auth.dto.response.AccessTokenResponse;
import com.sendiy.auth.dto.request.LoginRequest;
import com.sendiy.auth.dto.request.SetPasswordRequest;
import com.sendiy.auth.dto.request.UpdatePasswordRequest;
import com.sendiy.common.response.GenericResponse;
import com.sendiy.common.util.PathNames;
import com.sendiy.user.dto.request.UserCreateRequest;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author ahror
 * <p>
 * @since 10/10/2024
 */
@RequestMapping(PathNames.AUTH_V1)
@Validated
public interface AuthController {
    @PostMapping("/register")
    GenericResponse<HashMap<String, Object>> register(@Valid @RequestBody UserCreateRequest request);

    @GetMapping("/auth-type")
    GenericResponse<?> getAuthType(@RequestParam String phone);

    @PostMapping("/login")
    GenericResponse<AccessTokenResponse> login(@RequestBody LoginRequest request);

    @PostMapping("/otp")
    GenericResponse<?> sendOtp(@RequestParam String phone);

    @PostMapping("/refresh")
    GenericResponse<AccessTokenResponse> refresh(@RequestParam String refreshToken);

    @PostMapping("/set/password")
    GenericResponse<?> setPassword(@Valid @RequestBody SetPasswordRequest request);

    @PostMapping("/update/password")
    GenericResponse<?> updatePassword(@Valid @RequestBody UpdatePasswordRequest request);

    @GetMapping("/secured")
    @PreAuthorize("hasAuthority(T(com.sendiy.common.constant.PermissionConstant).HELLO)")
    GenericResponse<?> secured();
}
