package com.sellfinity.core.infrastructure.repository.product_category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryDto, Long> {

  void deleteByProductIdAndStoreId(Long productId, Long storeId);


}
