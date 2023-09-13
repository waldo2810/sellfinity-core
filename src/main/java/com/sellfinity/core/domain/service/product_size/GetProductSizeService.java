package com.sellfinity.core.domain.service.product_size;

import com.sellfinity.core.domain.entity.ProductSize;
import java.util.List;

public interface GetProductSizeService {

  List<ProductSize> findAllProductSizesBySize(Long sizeId);

  List<ProductSize> findAllProductSizesByProduct(Long productId);
}
