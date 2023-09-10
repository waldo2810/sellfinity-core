package com.sellfinity.core.infrastructure.api.color;

import com.sellfinity.core.domain.entity.Color;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ColorRequestMapper {

  @Mapping(target = "store.id", source = "storeId")
  Color toEntity(ColorRequest colorRequest);
}
