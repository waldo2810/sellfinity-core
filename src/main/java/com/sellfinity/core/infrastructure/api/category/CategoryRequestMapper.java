package com.sellfinity.core.infrastructure.api.category;

import com.sellfinity.core.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRequestMapper {

  Category toEntity(CategoryRequest categoryRequest);
}
