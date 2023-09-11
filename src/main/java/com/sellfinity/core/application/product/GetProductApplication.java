package com.sellfinity.core.application.product;

import com.sellfinity.core.application.image.GetImageApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductImage;
import com.sellfinity.core.domain.service.product.GetProductService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductApplication {

  private final GetProductService getProductService;
  private final GetStoreApplication getStoreApplication;
  private final GetImageApplication getImageApplication;

  public ProductImage findProductById(Long idProduct) {
    Product foundProduct = getProductService.findProductById(idProduct);
    List<Image> images = getImageApplication.findAllImagesByProduct(idProduct);

    return new ProductImage(foundProduct, images);
  }

  public List<ProductImage> findAllProducts(@Nullable Long storeId) {
    if (Objects.nonNull(storeId)) {
      getStoreApplication.findStoreById(storeId);
      List<Product> products = getProductService.findAllProductsByStoreId(storeId);
      return products.stream()
          .map(product -> {
            List<Image> images = getImageApplication.findAllImagesByProduct(product.getId());
            return new ProductImage(product, images);
          })
          .collect(Collectors.toList());
    }
    return getProductService.findAllProducts().stream()
        .map(product -> {
          List<Image> images = getImageApplication.findAllImagesByProduct(product.getId());
          return new ProductImage(product, images);
        })
        .collect(Collectors.toList());
  }
}