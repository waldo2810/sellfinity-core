package com.sellfinity.core.application.product_size;

import com.sellfinity.core.application.size.GetSizeApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductSize;
import com.sellfinity.core.domain.entity.Size;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductSizeApplication {

  private final DeleteProductSizeApplication deleteProductSizeApplication;
  private final GetSizeApplication getSizeApplication;
  private final SaveProductSizeApplication saveProductSizeApplication;

  public void updateProductSizes(Product product, List<Long> sizeIds) {
    deleteProductSizeApplication.deleteAllProductSizesByProductId(product.getId());
    sizeIds.forEach(sizeId -> {
      Size existingSize = getSizeApplication.findSizeById(sizeId);
      ProductSize productSize = new ProductSize();
      productSize.setProduct(product);
      productSize.setSize(existingSize);
      productSize.setStore(product.getStore());
      saveProductSizeApplication.saveProductSize(productSize);
    });
  }
}
