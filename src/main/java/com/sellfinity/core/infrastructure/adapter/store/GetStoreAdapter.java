package com.sellfinity.core.infrastructure.adapter.store;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.GetStoreService;
import com.sellfinity.core.infrastructure.repository.store.StoreRepository;
import com.sellfinity.core.infrastructure.repository.store.StoreRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.category.CategoryNotFoundException;
import com.sellfinity.core.shared.exception.notfound.store.StoreNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetStoreAdapter implements GetStoreService {

  private final StoreRepository storeRepository;
  private final StoreRepositoryMapper storeRepositoryMapper;




  @Override
  public Store findStoreById(Long id) {
    return storeRepositoryMapper.toEntity(storeRepository.findById(id)
        .orElseThrow(() -> new StoreNotFoundException(String.valueOf(id))));
  }

  @Override
  public List<Store> findAllStores() {
    return storeRepositoryMapper.toEntity(storeRepository.findAll());
  }
}
