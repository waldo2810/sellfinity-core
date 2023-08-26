package com.sellfinity.core.shared.exception.notfound.store;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class StoreNotFoundException extends NotFoundException {

  public StoreNotFoundException(String id) {
    super(String.format("Store with ID: %s was not found", id));
  }
}
