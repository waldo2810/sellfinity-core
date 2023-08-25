package com.sellfinity.core.application.store;

import com.sellfinity.core.application.users.GetUserApplication;
import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.GetStoreService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetStoreApplication {

  private final GetStoreService getStoreService;
  private final GetUserApplication getUserApplication;

  public Store findStoreById(Long idStore) {
    return getStoreService.findStoreById(idStore);
  }

  public List<Store> findAllStores(@Nullable Long userId) {
    if (Objects.nonNull(userId)) {
      getUserApplication.findUserById(userId);
      return getStoreService.findStoresByUserId(userId);
    }
    return getStoreService.findAllStores();
  }
}
