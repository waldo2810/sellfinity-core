package com.sellfinity.core.shared.exception.notfound.size;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class SizeNotFoundException extends NotFoundException {

  public SizeNotFoundException(String id) {
    super(String.format("Size with ID: %s was not found", id));
  }
}
