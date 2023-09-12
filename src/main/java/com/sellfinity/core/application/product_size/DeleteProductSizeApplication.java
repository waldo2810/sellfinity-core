package com.sellfinity.core.application.product_size;

import com.sellfinity.core.domain.service.product_size.DeleteProductSizeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductSizeApplication {

  private final DeleteProductSizeService deleteProductSizeService;

  public void deleteProductSize(Long productId, Long storeId) {
    deleteProductSizeService.deleteProductSize(productId, storeId);
  }
}