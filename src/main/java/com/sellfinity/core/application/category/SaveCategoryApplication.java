package com.sellfinity.core.application.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.SaveCategoryService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveCategoryApplication {

  private final SaveCategoryService saveCategoryService;

  public Category saveCategory(Category category) {
    category.setCreatedAt(LocalDateTime.now());
    return saveCategoryService.saveCategory(category);
  }
}
