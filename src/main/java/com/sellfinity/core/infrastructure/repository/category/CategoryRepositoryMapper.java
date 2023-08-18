package com.sellfinity.core.infrastructure.repository.category;

import com.sellfinity.core.domain.entity.Category;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRepositoryMapper {

  Category toEntity(CategoryDto categoryDto);

  List<Category> toEntity(List<CategoryDto> dtos);

  CategoryDto toDto(Category category);
}
