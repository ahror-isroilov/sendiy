package com.sendiy.common.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {
  private Object data;

  public NotFoundException(String message) {
    super(message, 404);
  }

  public NotFoundException(String message, Object data) {
    super(message, 404);
    this.data = data;
  }
}
