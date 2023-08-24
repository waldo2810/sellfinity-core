package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.service.store.DeleteStoreService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteStoreApplication {

  private final DeleteStoreService deleteStoreService;

  public void deleteStore(Long id) {
    deleteStoreService.deleteStore(id);
  }
}
