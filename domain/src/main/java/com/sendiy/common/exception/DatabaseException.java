package com.sendiy.common.exception;

import lombok.Getter;

@Getter
public class DatabaseException extends BaseException {
  private Object data;

  public DatabaseException(String message) {
    super(message, 500);
  }

  public DatabaseException(String message, Object data) {
    super(message, 500);
    this.data = data;
  }
}
