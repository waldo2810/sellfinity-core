package com.sellfinity.core.infrastructure.repository.product.custom;

import com.sellfinity.core.infrastructure.api.product.FindProductRequest;
import com.sellfinity.core.infrastructure.repository.product.ProductDto;
import java.util.List;

public interface ProductCustomRepository {

  List<ProductDto> findAllProductsCriteria(FindProductRequest query);
}
