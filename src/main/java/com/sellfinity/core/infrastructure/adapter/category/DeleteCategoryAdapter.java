package com.sellfinity.core.infrastructure.adapter.category;

import com.sellfinity.core.domain.service.category.DeleteCategoryService;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCategoryAdapter implements DeleteCategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }
}
