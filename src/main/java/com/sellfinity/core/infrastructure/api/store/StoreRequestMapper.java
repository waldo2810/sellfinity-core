package com.sellfinity.core.infrastructure.api.store;

import com.sellfinity.core.domain.entity.Store;
import org.mapstruct.Mapper;

@Mapper
public interface StoreRequestMapper {

  Store toEntity(StoreRequest storeRequest);
}
