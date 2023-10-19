package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.SaveStoreService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveStoreApplication {

  private final SaveStoreService saveStoreService;

  public Store saveStore(Store store, String userEmail) {
    store.setUserEmail(userEmail);
    store.setCreatedAt(LocalDateTime.now());
    return saveStoreService.saveStore(store);
  }
}
