package com.sellfinity.core.application.product_category;

import com.sellfinity.core.domain.entity.ProductCategory;
import com.sellfinity.core.domain.service.product_category.SaveProductCategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductCategoryApplication {

  private final SaveProductCategoryService saveProductCategoryService;

  public ProductCategory saveProductCategory(ProductCategory productCategory) {
    return saveProductCategoryService.saveProductCategory(productCategory);
  }
}