package com.sellfinity.core.shared.exception.notfound.category;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class CategoryNotFoundException extends NotFoundException {

  public CategoryNotFoundException(String id) {
    super(String.format("Category with ID: %s was not found", id));
  }
}
