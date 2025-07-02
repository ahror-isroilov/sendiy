package com.sendiy.common.exception;

import com.sendiy.common.constant.ErrorMessages;
import lombok.Getter;

@Getter
public class UserAlreadyExistsException extends BaseException {
  private Object data;

  public UserAlreadyExistsException() {
    super(ErrorMessages.USER_ALREADY_EXISTS, 409);
  }

  public UserAlreadyExistsException(Object data) {
    super(ErrorMessages.USER_ALREADY_EXISTS, 409);
    this.data = data;
  }
}
