package com.sellfinity.core.infrastructure.adapter.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.SaveStoreService;
import com.sellfinity.core.infrastructure.repository.store.StoreRepository;
import com.sellfinity.core.infrastructure.repository.store.StoreRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveStoreAdapter implements SaveStoreService {

  private final StoreRepository storeRepository;
  private final StoreRepositoryMapper storeRepositoryMapper;

  @Override
  public Store saveStore(Store store) {
    return storeRepositoryMapper.toEntity(storeRepository.save(storeRepositoryMapper.toDto(store)));
  }
}
