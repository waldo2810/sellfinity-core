package com.sellfinity.core.infrastructure.adapter.store;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.category.SaveCategoryService;
import com.sellfinity.core.domain.service.store.SaveStoreService;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepository;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepositoryMapper;
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
  public Store save(Store store) {
    return storeRepositoryMapper.toEntity(storeRepository.save(storeRepositoryMapper.toDto(store)));
  }
}
