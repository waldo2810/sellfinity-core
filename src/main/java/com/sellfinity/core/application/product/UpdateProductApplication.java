package com.sellfinity.core.application.product;

import com.sellfinity.core.application.image.UpdateImageApplication;
import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
import com.sellfinity.core.application.product_color.UpdateProductColorApplication;
import com.sellfinity.core.application.product_size.UpdateProductSizeApplication;
import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.UpdateProductService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductApplication {

  private final UpdateProductService updateProductService;
  private final GetProductApplication getProductApplication;
  private final DeleteProductCategoryApplication deleteProductCategoryApplication;
  private final SaveProductCategoryApplication saveProductCategoryApplication;
  private final UpdateImageApplication updateImageApplication;
  private final UpdateProductSizeApplication updateProductSizeApplication;
  private final UpdateProductColorApplication updateProductColorApplication;

  @Transactional
  public void updateProduct(Long id, Product product, List<Long> categoryIds, List<Long> sizeIds,
      List<Long> colorIds, List<Image> images) {
    getProductApplication.findProductById(id);

    updateProductService.updateProduct(id, product);
    Product updatedProduct = getProductApplication.findProductById(id).getProduct();

    deleteProductCategoryApplication.deleteProductCategory(id, product.getStore().getId());
    saveProductCategoryApplication.saveProductAndItsCategories(categoryIds, updatedProduct);

    if (Objects.nonNull(images)) {
      updateImageApplication.updateImage(id, updatedProduct, images);
    }
    if (sizeIds.size() > 0) {
      updateProductSizeApplication.updateProductSizes(updatedProduct, sizeIds);
    }
    if (colorIds.size() > 0) {
      updateProductColorApplication.updateProductColors(updatedProduct, colorIds);
    }
  }
}
