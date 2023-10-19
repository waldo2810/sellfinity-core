package com.sellfinity.core.shared.exception.notfound.color;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class ColorNotFoundException extends NotFoundException {

  public ColorNotFoundException(String id) {
    super(String.format("Color with ID: %s was not found", id));
  }
}
