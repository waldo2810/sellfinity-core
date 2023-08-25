package com.sellfinity.core.application.store;

import com.sellfinity.core.application.users.GetUserApplication;
import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.domain.service.store.SaveStoreService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveStoreApplication {

  private final SaveStoreService saveStoreService;
  private final GetUserApplication getUserApplication;

  public Store saveStore(Store store) {
    Users foundUser = getUserApplication.findUserById(store.getUser().getId());
    store.setUser(foundUser);
    store.setCreatedAt(LocalDateTime.now());
    return saveStoreService.saveStore(store);
  }
}
