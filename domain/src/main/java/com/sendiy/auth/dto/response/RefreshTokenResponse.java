package com.sendiy.auth.dto.response;

import com.sendiy.common.annotation.date_formatter.FormatDate;
import com.sendiy.user.dto.response.UserShortResponse;
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
public class RefreshTokenResponse {
    private UserShortResponse user;
    private String token;
    @FormatDate
    private LocalDateTime expiryDate;
}
