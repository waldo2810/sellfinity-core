package com.sellfinity.core.domain.service.product;

import com.sellfinity.core.domain.entity.Product;
import java.util.List;

public interface GetProductService {

  Product findProductById(Long idProduct);

  List<Product> findAllProducts();

  List<Product> findAllProductsByStoreId(Long storeId);
}
