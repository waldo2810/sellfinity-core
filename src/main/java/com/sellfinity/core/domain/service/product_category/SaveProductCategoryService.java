package com.sellfinity.core.domain.service.product_category;

import com.sellfinity.core.domain.entity.Product;
import java.util.List;

public interface SaveProductCategoryService {

  void saveProductCategory(Product product, List<Long> categoryIds);
}
