package com.sendiy.refresh_token.model;

import com.sendiy.common.annotation.date_formatter.FormatDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    private UUID userId;
    private String token;
    private LocalDateTime expiryDate;

    public RefreshToken(String token) {
        this.token = token;
    }
}
