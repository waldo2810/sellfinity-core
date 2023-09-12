package com.sellfinity.core.shared.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

  NOT_FOUND("ERR-001"),
  CONFLICT("ERR-002");

  private final String code;

  ExceptionCode(String code) {
    this.code = code;
  }
}
