package com.sendiy.common.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

/**
 * author: ahror
 *
 * <p>since: 03/10/2024
 */
@Getter
@Setter
public class GenericResponse<T> extends ResponseEntity<T> {

  private final long serverTime = System.currentTimeMillis();

  public GenericResponse(T data, HttpStatusCode status) {
    super(data, status);
  }

  public GenericResponse(HttpStatusCode status) {
    super(status);
  }

  public static <T> GenericResponse<T> success(T data) {
    return new GenericResponse<T>(data, HttpStatus.OK);
  }
}
