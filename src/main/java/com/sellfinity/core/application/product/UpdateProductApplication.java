package com.sellfinity.core.application.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.UpdateProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductApplication {

  private final UpdateProductService updateProductService;
  private final GetProductApplication getProductApplication;

  @Transactional
  public void updateProduct(Long idProduct, Long idStore, Product product) {
    getProductApplication.findProductById(idProduct);
    updateProductService.updateProduct(idProduct, idStore, product);
  }
}
