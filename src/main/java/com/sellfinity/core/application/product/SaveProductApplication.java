package com.sellfinity.core.application.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.SaveProductService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductApplication {

  private final SaveProductService saveProductService;

  public Product saveProduct(Product product) {
    product.setCreatedAt(LocalDateTime.now());
    return saveProductService.saveProduct(product);
  }
}
