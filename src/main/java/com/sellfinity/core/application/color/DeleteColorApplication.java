package com.sellfinity.core.application.color;

import com.sellfinity.core.domain.service.color.DeleteColorService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteColorApplication {

  private final DeleteColorService deleteColorService;

  public void deleteColor(Long id) {
    deleteColorService.deleteColor(id);
  }
}
