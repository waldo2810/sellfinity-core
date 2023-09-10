package com.sellfinity.core.application.size;

import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.size.SaveSizeService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveSizeApplication {

  private final SaveSizeService saveSizeService;

  public Size saveSize(Size color) {
    color.setCreatedAt(LocalDateTime.now());
    return saveSizeService.saveSize(color);
  }
}
