package com.sellfinity.core.application.product;

import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
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

  @Transactional
  public void updateProduct(Long idProduct, Long idStore, Product product, List<Long> categoryIds) {
    Product findProduct = getProductApplication.findProductById(idProduct);
    deleteProductCategoryApplication.deleteProductCategory(idProduct, idStore);
    updateProductService.updateProduct(idProduct, idStore, findProduct, categoryIds);
    saveProductCategoryApplication.saveProductAndItsCategories(categoryIds, findProduct);
  }
}
