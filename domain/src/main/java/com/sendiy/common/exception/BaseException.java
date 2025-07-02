package com.sendiy.common.exception;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
  private final int errorCode;
  private Object data;

  public BaseException(String message, int errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public BaseException(String message, int errorCode,Object data) {
    super(message);
    this.errorCode = errorCode;
    this.data = data;
  }

}
