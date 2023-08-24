package com.sellfinity.core.domain.service.store;

import com.sellfinity.core.domain.entity.Store;
import java.util.List;

public interface GetStoreService {

  Store findStoreById(Long idStore);

  List<Store> findAllStores();
}
