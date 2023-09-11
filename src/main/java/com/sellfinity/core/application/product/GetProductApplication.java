package com.sellfinity.core.application.product;

import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.GetProductService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductApplication {

  private final GetProductService getProductService;
  private final GetStoreApplication getStoreApplication;

  public Product findProductById(Long idProduct) {
    return getProductService.findProductById(idProduct);
  }

  public List<Product> findAllStores(@Nullable Long storeId) {
    if (Objects.nonNull(storeId)) {
      getStoreApplication.findStoreById(storeId);
      return getProductService.findAllProductsByStoreId(storeId);
    }
    return getProductService.findAllProducts();
  }
}