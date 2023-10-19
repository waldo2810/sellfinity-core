package com.sellfinity.core.application.image;

import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.entity.Product;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateImageApplication {

  private final DeleteImageApplication deleteImageApplication;
  private final SaveImageApplication saveImageApplication;

  public void updateImage(Long productId, Product updatedProduct, List<Image> images) {
    deleteImageApplication.deleteImageByProductId(productId);
    images.forEach(image -> {
      image.setProduct(updatedProduct);
      image.setCreatedAt(LocalDateTime.now());
      saveImageApplication.saveImage(image);
    });
  }
}
