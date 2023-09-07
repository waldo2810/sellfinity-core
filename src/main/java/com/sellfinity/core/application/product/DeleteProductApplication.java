package com.sellfinity.core.application.product;

import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.domain.service.product.DeleteProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class DeleteProductApplication {

  private final DeleteProductService deleteProductService;
  private final DeleteProductCategoryApplication deleteProductCategoryApplication;

  @Transactional
  public void deleteProduct(Long idProduct, Long idStore) {
    deleteProductCategoryApplication.deleteProductCategory(idProduct, idStore);
    deleteProductService.deleteProduct(idProduct, idStore);
  }
}
