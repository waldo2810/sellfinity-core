package com.sellfinity.core.shared.exception.notfound.product;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class ProductNotFoundException extends NotFoundException {

  public ProductNotFoundException(String id) {
    super(String.format("Product with ID: %s was not found", id));
  }
}
