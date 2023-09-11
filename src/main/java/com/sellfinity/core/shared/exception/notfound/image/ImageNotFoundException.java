package com.sellfinity.core.shared.exception.notfound.image;

import com.sellfinity.core.shared.exception.notfound.NotFoundException;

public class ImageNotFoundException extends NotFoundException {

  public ImageNotFoundException(String id) {
    super(String.format("Image with ID: %s was not found", id));
  }
}
