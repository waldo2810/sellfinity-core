package com.sellfinity.core.application.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.UpdateCategoryService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCategoryApplication {

  private final UpdateCategoryService updateCategoryService;
  private final GetCategoryApplication getCategoryApplication;

  @Transactional
  public void updateCategory(Long id, Category category) {
    getCategoryApplication.findCategoryById(id);
    category.setUpdatedAt(LocalDateTime.now());
    updateCategoryService.updateCategory(id, category);
  }
}
