package com.sendiy.common.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * author: ahror
 <p>
 * since: 30/10/2024
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class RateLimitFilter extends OncePerRequestFilter {
    private static final Map<String, Integer> RATE_LIMITED_ENDPOINTS = new HashMap<>() {{
        put("/auth/v1/otp", 3); // <URI, Max requests per minute>
    }};
    private final RateLimitService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (validUri(uri)) {
            String clientIp = getClientIP(request);
            String redisKey = clientIp + ":" + uri;
            Integer requestCount = getMaxRequestCount(uri);
            if (requestCount != null) {
                if (!service.tryAcquire(redisKey, requestCount)) {
                    response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                    response.setContentType("application/json");
                    response.getWriter().write("{\"message\": \"Too many requests. Please try again later.\", \"status\": 429}\"");
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private Integer getMaxRequestCount(String uri) {
        Optional<Integer> val = RATE_LIMITED_ENDPOINTS.entrySet().stream()
                .filter(e -> e.getKey().equals(uri))
                .map(Map.Entry::getValue)
                .findAny();
        return val.orElse(null);
    }

    private boolean validUri(String uri) {
        return RATE_LIMITED_ENDPOINTS.keySet().stream()
                .anyMatch(key -> key.equals(uri));
    }

    private String getClientIP(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0];
        }
        return request.getRemoteAddr();
    }

    @Service
    @RequiredArgsConstructor
    static class RateLimitService {
        private final RedisTemplate<String, String> template;

        public boolean tryAcquire(String key, Integer maxRequests) {
            ValueOperations<String, String> ops = template.opsForValue();
            String countStr = ops.get(key);
            int count = countStr == null ? 0 : Integer.parseInt(countStr);
            if (count >= maxRequests) {
                return false;
            }
            if (count == 0)
                ops.set(key, "1", Duration.ofMinutes(1));
            else ops.increment(key);
            return true;
        }

    }
}
