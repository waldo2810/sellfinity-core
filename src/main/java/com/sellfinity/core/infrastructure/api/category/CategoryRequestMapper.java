package com.sellfinity.core.infrastructure.api.category;

import com.sellfinity.core.domain.entity.Category;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryRequestMapper {
  @Mapping(target = "store.id", source = "storeId")
  Category toEntity(CategoryRequest categoryRequest);
}
