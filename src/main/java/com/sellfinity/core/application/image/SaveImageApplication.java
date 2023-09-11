package com.sellfinity.core.application.image;

import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.service.image.SaveImageService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveImageApplication {

  private final SaveImageService saveImageService;

  public Image saveImage(Image image) {
    return saveImageService.saveImage(image);
  }
}
