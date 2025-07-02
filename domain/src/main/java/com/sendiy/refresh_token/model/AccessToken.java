package com.sendiy.refresh_token.model;

import com.sendiy.common.annotation.date_formatter.FormatDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {
    private String token;
    private RefreshToken refreshToken;
    private LocalDateTime expiryDate;
}
