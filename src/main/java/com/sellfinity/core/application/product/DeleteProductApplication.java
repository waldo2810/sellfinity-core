package com.sellfinity.core.application.product;

import com.sellfinity.core.domain.service.product.DeleteProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductApplication {

  private final DeleteProductService deleteProductService;

  public void deleteProduct(Long idProduct,Long idStore) {
    deleteProductService.deleteProduct(idProduct,idStore);
  }
}
