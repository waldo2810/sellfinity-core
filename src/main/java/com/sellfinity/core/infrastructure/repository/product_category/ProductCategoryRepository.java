package com.sellfinity.core.infrastructure.repository.product_category;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryDto, Long> {

  @Transactional
  void deleteByProductIdAndStoreId(Long productId, Long storeId);


}
