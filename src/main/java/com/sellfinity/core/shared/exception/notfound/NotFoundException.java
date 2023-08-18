package com.sellfinity.core.shared.exception.notfound;

import com.sellfinity.core.shared.exception.BaseException;
import com.sellfinity.core.shared.exception.ExceptionCode;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

  protected NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message, ExceptionCode.NOT_FOUND);
  }
}
