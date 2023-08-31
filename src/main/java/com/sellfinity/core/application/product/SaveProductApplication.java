package com.sellfinity.core.application.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.SaveProductService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductApplication {

  private final SaveProductService saveProductService;

  public Product saveProduct(Product product, List<Long> categoryIds) {
    product.setCreatedAt(LocalDateTime.now());
    System.out.println(product.getId());
    return saveProductService.saveProduct(product, categoryIds);
  }
}
