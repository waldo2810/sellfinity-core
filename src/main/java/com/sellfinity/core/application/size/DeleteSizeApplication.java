package com.sellfinity.core.application.size;

import com.sellfinity.core.domain.service.size.DeleteSizeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteSizeApplication {

  private final DeleteSizeService deleteSizeService;

  public void deleteSize(Long id) {
    deleteSizeService.deleteSize(id);
  }
}
