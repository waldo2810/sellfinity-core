package com.sellfinity.core.shared.exception.notfound.user;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class UserNotFoundException extends NotFoundException {

  public UserNotFoundException(String id) {
    super(String.format("User with ID: %s was not found", id));
  }
}
