package com.sellfinity.core.application.product;

import com.sellfinity.core.application.image.DeleteImageApplication;
import com.sellfinity.core.application.image.GetImageApplication;
import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.product_color.DeleteProductColorApplication;
import com.sellfinity.core.application.product_size.DeleteProductSizeApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.DeleteProductService;
import jakarta.transaction.Transactional;
import java.util.Objects;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class DeleteProductApplication {

  private final DeleteProductService deleteProductService;
  private final DeleteProductCategoryApplication deleteProductCategoryApplication;
  private final DeleteProductSizeApplication deleteProductSizeApplication;
  private final DeleteProductColorApplication deleteProductColorApplication;
  private final DeleteImageApplication deleteImageApplication;
  private final GetImageApplication getImageApplication;
  private final GetProductApplication getProductApplication;

  @Transactional
  public void deleteProduct(Long id) {
    Product existingProduct = getProductApplication.findProductById(id).getProduct();
    Long storeId = existingProduct.getStore().getId();
    deleteProductCategoryApplication.deleteProductCategory(id, storeId);
    deleteProductSizeApplication.deleteProductSize(id, storeId);
    deleteProductColorApplication.deleteProductColor(id, storeId);
    if (Objects.nonNull(getImageApplication.findAllImagesByProduct(id))) {
      deleteImageApplication.deleteImageByProductId(id);
    }
    deleteProductService.deleteProduct(id);
  }
}
