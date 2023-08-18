package com.sellfinity.core.application.category;

import com.sellfinity.core.domain.service.category.DeleteCategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCategoryApplication {

  private final DeleteCategoryService deleteCategoryService;

  public void deleteCategory(Long id) {
    deleteCategoryService.deleteCategory(id);
  }
}
