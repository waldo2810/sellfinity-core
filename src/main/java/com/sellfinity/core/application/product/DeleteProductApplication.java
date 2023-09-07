package com.sellfinity.core.application.product;

import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.service.product.DeleteProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class DeleteProductApplication {

  private final DeleteProductService deleteProductService;
  private final DeleteProductCategoryApplication deleteProductCategoryApplication;
  private final GetStoreApplication getStoreApplication;
  private final GetProductApplication getProductApplication;

  @Transactional
  public void deleteProduct(Long idProduct, Long idStore) {
    getStoreApplication.findStoreById(idStore);
    getProductApplication.findProductById(idProduct);
    deleteProductCategoryApplication.deleteProductCategory(idProduct, idStore);
    deleteProductService.deleteProduct(idProduct, idStore);
  }
}
