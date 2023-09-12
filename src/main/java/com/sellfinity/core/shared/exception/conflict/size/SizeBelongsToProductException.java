package com.sellfinity.core.shared.exception.conflict.size;

import com.sellfinity.core.shared.exception.conflict.ConflictException;

public class SizeBelongsToProductException extends ConflictException {

  public SizeBelongsToProductException(String id) {
    super(String.format("Size with ID %s currently belongs to products", id));
  }
}
