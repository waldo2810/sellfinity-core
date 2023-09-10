package com.sellfinity.core.application.color;

import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.service.color.SaveColorService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveColorApplication {

  private final SaveColorService saveColorService;

  public Color saveColor(Color color) {
    color.setCreatedAt(LocalDateTime.now());
    return saveColorService.saveColor(color);
  }
}
