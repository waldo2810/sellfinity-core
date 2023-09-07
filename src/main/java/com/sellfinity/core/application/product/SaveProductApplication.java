package com.sellfinity.core.application.product;

import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.SaveProductService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductApplication {

  private final SaveProductService saveProductService;
  private final SaveProductCategoryApplication saveProductCategoryApplication;

  @Transactional
  public Product saveProduct(Product product, List<Long> categoryIds) {
    product.setCreatedAt(LocalDateTime.now());
    Product savedProduct = saveProductService.saveProduct(product);

    saveProductCategoryApplication.saveProductAndItsCategories(categoryIds, savedProduct);

    return savedProduct;
  }
}