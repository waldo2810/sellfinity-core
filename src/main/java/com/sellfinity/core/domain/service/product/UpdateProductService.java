package com.sellfinity.core.domain.service.product;

import com.sellfinity.core.domain.entity.Product;
import java.util.List;

public interface UpdateProductService {

  void updateProduct(Long idProduct, Long idStore, Product product, List<Long> categoryIds);
}
