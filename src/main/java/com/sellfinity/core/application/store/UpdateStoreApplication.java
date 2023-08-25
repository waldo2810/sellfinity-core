package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.service.store.UpdateStoreService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateStoreApplication {

  private final UpdateStoreService updateStoreService;
  private final GetStoreApplication getStoreApplication;

  @Transactional
  public void updateStore(Long id, String name) {
    getStoreApplication.findStoreById(id);
    updateStoreService.updateStore(id, name);
  }
}
