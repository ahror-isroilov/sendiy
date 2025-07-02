package com.sendiy.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * author: ahror
 * <p>
 * since: 11/10/2024
 */
@Getter
@RequiredArgsConstructor
@ToString
public class ErrorResponse {
    private final int errorCode;
    private final String message;
    private final String details;
    private Object data;

    public ErrorResponse(int errorCode, String message, String details, Object data) {
        this(errorCode, message, details);
        this.data = data;
    }
}