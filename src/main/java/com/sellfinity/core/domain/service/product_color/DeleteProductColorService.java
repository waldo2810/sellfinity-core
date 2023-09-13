package com.sellfinity.core.domain.service.product_color;

public interface DeleteProductColorService {

  void deleteProductColor(Long productId, Long storeId);

  void deleteAllProductColorsByProductId(Long id);
}
