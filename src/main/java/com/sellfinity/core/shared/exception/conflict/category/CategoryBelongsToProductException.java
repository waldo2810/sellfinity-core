package com.sellfinity.core.shared.exception.conflict.category;

import com.sellfinity.core.shared.exception.conflict.ConflictException;

public class CategoryBelongsToProductException extends ConflictException {

  public CategoryBelongsToProductException(String id) {
    super(String.format("Category with ID %s currently belongs to products", id));
  }
}
