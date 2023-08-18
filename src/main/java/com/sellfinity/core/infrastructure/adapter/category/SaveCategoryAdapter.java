package com.sellfinity.core.infrastructure.adapter.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.SaveCategoryService;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepository;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveCategoryAdapter implements SaveCategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryRepositoryMapper categoryRepositoryMapper;

  @Override
  public Category saveCategory(Category category) {
    return categoryRepositoryMapper.toEntity(
        categoryRepository.save(categoryRepositoryMapper.toDto(category)));
  }
}
