package com.sellfinity.core.application.product;

import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.UpdateProductService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductApplication {

  private final UpdateProductService updateProductService;
  private final GetProductApplication getProductApplication;
  private final DeleteProductCategoryApplication deleteProductCategoryApplication;
  private final SaveProductCategoryApplication saveProductCategoryApplication;
  private final GetStoreApplication getStoreApplication;

  @Transactional
  public void updateProduct(Product product, List<Long> categoryIds) {
    getStoreApplication.findStoreById(product.getStore().getId());
    getProductApplication.findProductById(product.getId());

    deleteProductCategoryApplication.deleteProductCategory(product.getId(),
        product.getStore().getId());
    updateProductService.updateProduct(product);
    Product updatedProduct = getProductApplication.findProductById(product.getId());
    saveProductCategoryApplication.saveProductAndItsCategories(categoryIds, updatedProduct);
  }
}
