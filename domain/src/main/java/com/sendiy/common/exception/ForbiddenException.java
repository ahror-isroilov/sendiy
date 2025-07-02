package com.sendiy.common.exception;

import lombok.Getter;

@Getter
public class ForbiddenException extends BaseException {
  private Object data;

  public ForbiddenException(String message) {
    super(message, 403);
  }

  public ForbiddenException(String message, Object data) {
    super(message, 403,data);
    this.data = data;
  }
}
