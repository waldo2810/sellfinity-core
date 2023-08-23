package com.sellfinity.core.infrastructure.adapter.store;

import com.sellfinity.core.domain.service.store.UpdateStoreService;
import com.sellfinity.core.infrastructure.repository.store.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateStoreAdapter implements UpdateStoreService {

  private final StoreRepository storeRepository;

  @Override
  public void updateStore(Long id, String name) {
    storeRepository.updateStore(id, name);
  }
}
