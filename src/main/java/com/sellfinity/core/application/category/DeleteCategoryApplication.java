package com.sellfinity.core.application.category;

import com.sellfinity.core.application.category.validator.DeleteCategoryValidator;
import com.sellfinity.core.domain.service.category.DeleteCategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCategoryApplication {

  private final DeleteCategoryService deleteCategoryService;
  private final DeleteCategoryValidator deleteCategoryValidator;

  public void deleteCategory(Long id, Long storeId) {
    deleteCategoryValidator.validateCategory(id, storeId);
    deleteCategoryService.deleteCategory(id);
  }
}
