package com.sellfinity.core.domain.service.product;

import com.sellfinity.core.domain.entity.Product;

public interface UpdateProductService {

  void updateProduct(Long id, Product product);
}