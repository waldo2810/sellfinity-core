package com.sellfinity.core.application.size;

import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.size.UpdateSizeService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateSizeApplication {

  private final UpdateSizeService updateSizeService;
  private final GetSizeApplication getSizeApplication;

  @Transactional
  public void updateSize(Long id, Size color) {
    getSizeApplication.findSizeById(id);
    color.setUpdatedAt(LocalDateTime.now());
    updateSizeService.updateSize(id, color);
  }
}
