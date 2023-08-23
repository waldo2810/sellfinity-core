package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.GetStoreService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetStoreApplication {

  private final GetStoreService getStoreService;

  public Store findStoreById(Long idStore) {
    return getStoreService.findStoreById(idStore);
  }

  public List<Store> findAllStores() {
    return getStoreService.findAllStores();
  }
}
