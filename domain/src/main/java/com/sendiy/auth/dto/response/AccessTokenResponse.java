package com.sendiy.auth.dto.response;

import com.sendiy.common.annotation.date_formatter.FormatDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * author: ahror
 * <p>
 * since: 18/10/2024
 */
@Getter
@AllArgsConstructor
public class AccessTokenResponse {
    private String token;
    @FormatDate
    private LocalDateTime expiryDate;
    private RefreshTokenResponse refreshToken;
}
