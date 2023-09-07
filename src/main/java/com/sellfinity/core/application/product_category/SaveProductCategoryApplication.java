package com.sellfinity.core.application.product_category;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductCategory;
import com.sellfinity.core.domain.service.product_category.SaveProductCategoryService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductCategoryApplication {

  private final SaveProductCategoryService saveProductCategoryService;
  private final GetCategoryApplication getCategoryApplication;

  public ProductCategory saveProductCategory(ProductCategory productCategory) {
    return saveProductCategoryService.saveProductCategory(productCategory);
  }

  public void saveProductAndItsCategories(List<Long> categoryIds, Product savedProduct) {
    List<ProductCategory> productCategoryList = categoryIds.stream()
        .map(category -> {
          Category foundCategory = getCategoryApplication.findCategoryById(category);
          ProductCategory productCategory = new ProductCategory();
          productCategory.setProduct(savedProduct);
          productCategory.setCategory(foundCategory);
          productCategory.setStore(savedProduct.getStore());
          return productCategory;
        }).collect(Collectors.toList());
    productCategoryList.forEach(saveProductCategoryService::saveProductCategory);
  }
}