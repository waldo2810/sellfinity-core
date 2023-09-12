package com.sellfinity.core.application.product_size;

import com.sellfinity.core.application.size.GetSizeApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductSize;
import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.product_size.SaveProductSizeService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductSizeApplication {

  private final SaveProductSizeService saveProductSizeService;
  private final GetSizeApplication getSizeApplication;

  public ProductSize saveProductSize(ProductSize productSize) {
    return saveProductSizeService.saveProductSize(productSize);
  }

  public void saveProductAndItsSizes(List<Long> sizeIds, Product savedProduct) {
    List<ProductSize> productSizeList = sizeIds.stream()
        .map(size -> {
          Size foundSize = getSizeApplication.findSizeById(size);
          ProductSize productSize = new ProductSize();
          productSize.setProduct(savedProduct);
          productSize.setSize(foundSize);
          productSize.setStore(savedProduct.getStore());
          return productSize;
        }).collect(Collectors.toList());
    productSizeList.forEach(saveProductSizeService::saveProductSize);
  }
}