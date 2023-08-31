package com.sellfinity.core.domain.service.product;

import com.sellfinity.core.domain.entity.Product;
import java.util.List;

public interface SaveProductService {

  Product saveProduct(Product product, List<Long> categoryIds);
}
