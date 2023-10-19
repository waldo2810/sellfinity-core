package com.sellfinity.core.application.image;

import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.service.image.GetImageService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetImageApplication {

  private final GetImageService getImageService;

  public List<Image> findAllImagesByProduct(Long productId) {
    return getImageService.findAllImagesByProduct(productId);
  }

  public Image findImageById(Long id) {
    return getImageService.findImageById(id);
  }
}
