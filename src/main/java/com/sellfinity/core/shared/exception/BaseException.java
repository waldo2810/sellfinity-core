package com.sellfinity.core.shared.exception;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends RuntimeException {

  private static final long serialVersionUID = -824690113517284691L;
  private final HttpStatus status;
  private final String code;
  private final String message;
  private final LocalDateTime date;
  private final ExceptionCode exceptionCode;
  private final String id = UUID.randomUUID().toString();

  protected BaseException(HttpStatus status, String message,
      ExceptionCode exceptionCode) {
    this.code = exceptionCode.getCode();
    this.message = message;
    this.status = status;
    this.exceptionCode = exceptionCode;
    this.date = LocalDateTime.now(ZoneId.systemDefault());
  }
}
