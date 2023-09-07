package com.sellfinity.core.application.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.GetProductService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductApplication {

  private final GetProductService getProductService;

  public Product findProductById(Long idProduct) {return getProductService.findProductById(idProduct);}

  public List<Product> findAllStores() {
    return getProductService.findAllProducts();
  }
}
