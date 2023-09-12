package com.sellfinity.core.application.product_color;

import com.sellfinity.core.domain.service.product_color.DeleteProductColorService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductColorApplication {

  private final DeleteProductColorService deleteProductColorService;

  public void deleteProductColor(Long productId, Long storeId) {
    deleteProductColorService.deleteProductColor(productId, storeId);
  }
}