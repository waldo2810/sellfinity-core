package com.sellfinity.core.application.image;

import com.sellfinity.core.domain.service.image.DeleteImageService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteImageApplication {

  private final DeleteImageService deleteImageService;

  public void deleteImageByProductId(Long productId) {
    deleteImageService.deleteImageByProductId(productId);
  }
}
