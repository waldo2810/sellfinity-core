package com.sellfinity.core.infrastructure.adapter.store;

import com.sellfinity.core.domain.service.store.DeleteStoreService;
import com.sellfinity.core.infrastructure.repository.store.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteStoreAdapter implements DeleteStoreService {

  private final StoreRepository storeRepository;

  @Override
  public void deleteStore(Long id) {
    storeRepository.deleteById(id);
  }
}
