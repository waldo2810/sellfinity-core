package com.sellfinity.core.infrastructure.api.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StoreRequestMapper extends EntityToDto<Store, StoreRequest> {

  @Mapping(target = "user.id", source = "userId")
  Store toEntity(StoreRequest storeRequest);
}
