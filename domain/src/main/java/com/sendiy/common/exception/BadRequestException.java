package com.sendiy.common.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends BaseException {
  private Object data;

  public BadRequestException(String message) {
    super(message, 400);
  }

  public BadRequestException(String message, Object data) {
    super(message, 400);
    this.data = data;
  }
}
