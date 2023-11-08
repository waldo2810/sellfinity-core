package com.sellfinity.core.application.color;

import com.sellfinity.core.application.color.validator.DeleteColorValidator;
import com.sellfinity.core.domain.service.color.DeleteColorService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteColorApplication {

  private final DeleteColorService deleteColorService;
  private final DeleteColorValidator deleteColorValidator;

  public void deleteColor(Long id, Long storeId) {
    deleteColorValidator.validateColor(id, storeId);
    deleteColorService.deleteColor(id);
  }
}
