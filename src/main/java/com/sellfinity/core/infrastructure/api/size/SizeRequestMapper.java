package com.sellfinity.core.infrastructure.api.size;

import com.sellfinity.core.domain.entity.Size;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SizeRequestMapper {

  @Mapping(target = "store.id", source = "storeId")
  Size toEntity(SizeRequest sizeRequest);
}
