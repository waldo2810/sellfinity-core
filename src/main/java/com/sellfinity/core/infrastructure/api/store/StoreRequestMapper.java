package com.sellfinity.core.infrastructure.api.store;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.infrastructure.api.category.CategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StoreRequestMapper {
  Store toEntity(StoreRequest storeRequest);
}
