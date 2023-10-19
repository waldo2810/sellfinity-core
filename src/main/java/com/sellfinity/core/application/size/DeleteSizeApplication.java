package com.sellfinity.core.application.size;

import com.sellfinity.core.application.size.validator.DeleteSizeValidator;
import com.sellfinity.core.domain.service.size.DeleteSizeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteSizeApplication {

  private final DeleteSizeService deleteSizeService;
  private final DeleteSizeValidator deleteSizeValidator;

  public void deleteSize(Long id) {
    deleteSizeValidator.validateSize(id);
    deleteSizeService.deleteSize(id);
  }
}
