package com.sellfinity.core.infrastructure.adapter.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.UpdateCategoryService;
import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepository;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCategoryAdapter implements UpdateCategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryRepositoryMapper categoryRepositoryMapper;

  @Override
  public void updateCategory(Long id, Category category) {
    CategoryDto categoryDto = categoryRepositoryMapper.toDto(category);
    categoryRepository.save(categoryDto); //TODO USAR QUERY
  }
}
