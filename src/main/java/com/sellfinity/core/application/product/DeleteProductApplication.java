package com.sellfinity.core.application.product;

import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.DeleteProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class DeleteProductApplication {

  private final DeleteProductService deleteProductService;
  private final DeleteProductCategoryApplication deleteProductCategoryApplication;
  private final GetProductApplication getProductApplication;

  @Transactional
  public void deleteProduct(Long id) {
    Product existingProduct = getProductApplication.findProductById(id).getProduct();
    Long storeId = existingProduct.getStore().getId();
    deleteProductCategoryApplication.deleteProductCategory(id, storeId);
    deleteProductService.deleteProduct(id);
  }
}
