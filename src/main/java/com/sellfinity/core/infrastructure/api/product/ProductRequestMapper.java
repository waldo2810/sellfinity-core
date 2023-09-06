package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductRequestMapper {

  @Mapping(target = "store.id", source = "storeId")
  Product toEntity(ProductRequest productRequest);
}