package com.sellfinity.core.application.color;

import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.service.color.UpdateColorService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateColorApplication {

  private final UpdateColorService updateColorService;
  private final GetColorApplication getColorApplication;

  @Transactional
  public void updateColor(Long id, Color color) {
    getColorApplication.findColorById(id);
    color.setUpdatedAt(LocalDateTime.now());
    updateColorService.updateColor(color);
  }
}
