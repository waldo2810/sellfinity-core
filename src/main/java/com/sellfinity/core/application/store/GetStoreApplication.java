package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.GetStoreService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetStoreApplication {

  private final GetStoreService getStoreService;

  public Store findStoreById(Long idStore) {
    return getStoreService.findStoreById(idStore);
  }

  public List<Store> findAllStores(@Nullable String userEmail) {
    return (Objects.nonNull(userEmail)) ? getStoreService.findStoresByUserEmail(userEmail)
        : getStoreService.findAllStores();
  }
}
