package com.sellfinity.core.infrastructure.adapter.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.UpdateStoreService;
import com.sellfinity.core.infrastructure.repository.store.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateStoreAdapter implements UpdateStoreService {

  private final StoreRepository storeRepository;

  @Override
  public void updateStore(Long id, Store store) {
    String name = store.getName();
    storeRepository.updateStore(id, name);
  }
}