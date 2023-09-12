package com.sellfinity.core.application.category.validator;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.product.GetProductApplication;
import com.sellfinity.core.shared.exception.conflict.category.CategoryBelongsToProductException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCategoryValidator {

  private final GetCategoryApplication getCategoryApplication;
  private final GetProductApplication getProductApplication;

  public void validateCategory(Long categoryId) {
    getCategoryApplication.findCategoryById(categoryId);
    if (isRelatedToProducts(categoryId)) {
      throw new CategoryBelongsToProductException(String.valueOf(categoryId));
    }
  }

  private boolean isRelatedToProducts(Long categoryId) {
    return getProductApplication.findAllProductsByCategory(categoryId).size() > 0;
  }
}
