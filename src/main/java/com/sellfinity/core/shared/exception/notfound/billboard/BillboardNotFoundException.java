package com.sellfinity.core.shared.exception.notfound.billboard;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class BillboardNotFoundException extends NotFoundException {

  public BillboardNotFoundException(String id) {
    super(String.format("Billboard with ID: %s was not found", id));
  }
}
