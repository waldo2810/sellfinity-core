package com.sellfinity.core.infrastructure.adapter.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.UpdateCategoryService;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCategoryAdapter implements UpdateCategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public void updateCategory(Long id, Category category) {
    categoryRepository.updateCategory(id, category.getName(), category.getUpdatedAt());
  }
}
