package com.sendiy.user.web.controller;

import com.sendiy.common.response.GenericResponse;
import com.sendiy.common.util.PathNames;
import com.sendiy.user.dto.request.UserCreateRequest;
import com.sendiy.user.dto.response.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * author: ahror
 *
 * <p>since: 08/10/2024
 */
@RequestMapping(PathNames.USER_V1)
public interface UserController {
    @PostMapping("/register")
    GenericResponse<UUID> register(@RequestBody UserCreateRequest request);

    @GetMapping("/get")
    GenericResponse<UserResponse> get(@RequestParam(name = "id") UUID uuid);

    @GetMapping("/get-detailed")
    GenericResponse<?> getDetailed(
            @RequestParam(name = "id") UUID uuid,
            @RequestParam(name = "role") boolean role,
            @RequestParam(name = "avatar") boolean avatar);
}
