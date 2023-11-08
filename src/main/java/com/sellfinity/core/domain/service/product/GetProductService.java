package com.sellfinity.core.domain.service.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.infrastructure.api.product.FindProductRequest;
import java.util.List;

public interface GetProductService {

  Product findProductById(Long idProduct);

  List<Product> findAllProducts();

  List<Product> findAllProductsByStoreId(Long storeId);

  List<Product> findAllProductsBySize(Long sizeId, Long storeId);

  List<Product> findAllProductsByColor(Long colorId, Long storeId);

  List<Product> findAllProductsByCategory(Long categoryId, Long storeId);

  List<Product> findFeaturedProductsByStoreId(Long storeId);

  Long getProductCount(Long storeId);

  List<Product> findAllProductsCriteria(FindProductRequest req);
}
