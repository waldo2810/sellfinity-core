package com.sellfinity.core.application.product_color;

import com.sellfinity.core.application.color.GetColorApplication;
import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductColor;
import com.sellfinity.core.domain.service.product_color.SaveProductColorService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductColorApplication {

  private final SaveProductColorService saveProductColorService;
  private final GetColorApplication getColorApplication;

  public ProductColor saveProductColor(ProductColor productColor) {
    return saveProductColorService.saveProductColor(productColor);
  }

  public void saveProductAndItsColors(List<Long> colorIds, Product savedProduct) {
    List<ProductColor> productColorList = colorIds.stream()
        .map(color -> {
          Color foundColor = getColorApplication.findColorById(color);
          ProductColor productCategory = new ProductColor();
          productCategory.setProduct(savedProduct);
          productCategory.setColor(foundColor);
          productCategory.setStore(savedProduct.getStore());
          return productCategory;
        }).collect(Collectors.toList());
    productColorList.forEach(saveProductColorService::saveProductColor);
  }
}