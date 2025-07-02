package com.sendiy.common.exception;

import lombok.Getter;

@Getter
public class BadCredentialsException extends BaseException {
    private Object data;

    public BadCredentialsException(String message) {
        super(message, 401);
    }

    public BadCredentialsException(String message, Object data) {
        super(message, 401);
        this.data = data;
    }
}
