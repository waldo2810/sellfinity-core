package com.sellfinity.core.application.product;

import com.sellfinity.core.application.image.DeleteImageApplication;
import com.sellfinity.core.application.image.SaveImageApplication;
import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.UpdateProductService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductApplication {

  private final UpdateProductService updateProductService;
  private final GetProductApplication getProductApplication;
  private final DeleteProductCategoryApplication deleteProductCategoryApplication;
  private final DeleteImageApplication deleteImageApplication;
  private final SaveProductCategoryApplication saveProductCategoryApplication;
  private final SaveImageApplication saveImageApplication;

  @Transactional
  public void updateProduct(Long id, Product product, List<Long> categoryIds,
      List<Image> images) {
    getProductApplication.findProductById(id);

    deleteProductCategoryApplication.deleteProductCategory(id, product.getStore().getId());

    updateProductService.updateProduct(id, product);
    Product updatedProduct = getProductApplication.findProductById(id).getProduct();

    saveProductCategoryApplication.saveProductAndItsCategories(categoryIds, updatedProduct);

    if (Objects.nonNull(images)) {
      deleteImageApplication.deleteImageByProductId(id);
      images.forEach(image -> {
        image.setProduct(updatedProduct);
        image.setCreatedAt(LocalDateTime.now());
        saveImageApplication.saveImage(image);
      });
    }
  }
}
