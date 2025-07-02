package com.sendiy.common.util;

import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * author: ahror
 * <p>
 * since: 10/10/2024
 */
public final class SecurityUtil {
    public static final Map<String, HttpMethod> OPEN_ENDPOINTS = new HashMap<>();
    static {
        OPEN_ENDPOINTS.put("/auth/v1/register", HttpMethod.POST);
        OPEN_ENDPOINTS.put("/auth/v1/send-otp", HttpMethod.GET);
        OPEN_ENDPOINTS.put("/auth/v1/login", HttpMethod.POST);
        OPEN_ENDPOINTS.put("/auth/v1/auth-type", HttpMethod.GET);
        OPEN_ENDPOINTS.put("/auth/v1/otp-login", HttpMethod.POST);
    }
}
