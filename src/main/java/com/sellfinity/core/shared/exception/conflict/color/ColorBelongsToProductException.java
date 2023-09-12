package com.sellfinity.core.shared.exception.conflict.color;

import com.sellfinity.core.shared.exception.conflict.ConflictException;

public class ColorBelongsToProductException extends ConflictException {

  public ColorBelongsToProductException(String id) {
    super(String.format("Color with ID %s currently belongs to products", id));
  }
}
