package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.GetStoreService;
import com.sellfinity.core.domain.service.store.SaveStoreService;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
