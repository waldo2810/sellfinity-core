package com.sellfinity.core.application.product_category;

import com.sellfinity.core.domain.service.product_category.DeleteProductCategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductCategoryApplication {

  private final DeleteProductCategoryService deleteProductCategoryService;

  public void deleteProductCategory(Long productId, Long storeId) {
    deleteProductCategoryService.deleteProductCategory(productId, storeId);
  }
}