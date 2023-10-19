package com.sellfinity.core.application.product_color;

import com.sellfinity.core.application.color.GetColorApplication;
import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductColor;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductColorApplication {

  private final DeleteProductColorApplication deleteProductColorApplication;
  private final GetColorApplication getColorApplication;
  private final SaveProductColorApplication saveProductColorApplication;


  public void updateProductColors(Product product, List<Long> colorIds) {
    deleteProductColorApplication.deleteAllProductColorsByProductId(product.getId());
    colorIds.forEach(colorId -> {
      Color existingColor = getColorApplication.findColorById(colorId);
      ProductColor productColor = new ProductColor();
      productColor.setProduct(product);
      productColor.setColor(existingColor);
      productColor.setStore(product.getStore());
      saveProductColorApplication.saveProductColor(productColor);
    });
  }
}
