package com.sellfinity.core.application.product;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductCategory;
import com.sellfinity.core.domain.service.product.SaveProductService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductApplication {

  private final SaveProductService saveProductService;
  private final GetCategoryApplication getCategoryApplication;
  private final SaveProductCategoryApplication saveProductCategoryApplication;

  @Transactional
  public Product saveProduct(Product product, List<Long> categoryIds) {
    categoryIds.forEach(getCategoryApplication::findCategoryById);
    product.setCreatedAt(LocalDateTime.now());
    Product savedProduct = saveProductService.saveProduct(product);

    saveProductAndItsCategories(categoryIds, savedProduct);

    return savedProduct;
  }

  private void saveProductAndItsCategories(List<Long> categoryIds, Product savedProduct) {
    List<ProductCategory> productCategoryList = categoryIds.stream()
        .map(getCategoryApplication::findCategoryById)
        .map(category -> {
          ProductCategory productCategory = new ProductCategory();
          productCategory.setProduct(savedProduct.getId());
          productCategory.setCategory(category.getId());
          productCategory.setStore(savedProduct.getStore().getId());
          return productCategory;
        }).collect(Collectors.toList());
    productCategoryList.forEach(saveProductCategoryApplication::saveProductCategory);
  }
}