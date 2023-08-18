package com.sellfinity.core.infrastructure.api.category;

import com.sellfinity.core.domain.entity.Category;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryResponseMapper {

  CategoryResponse toResponse(Category category);

  List<CategoryResponse> toResponse(List<Category> category);
}
