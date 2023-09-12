package com.sellfinity.core.infrastructure.repository.product_size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductSizeRepository extends JpaRepository<ProductSizeDto, Long> {

  @Modifying
  @Query("DELETE FROM ProductSizeDto pc WHERE pc.product.id = :productId AND pc.store.id = :storeId")
  void deleteByProductIdAndStoreId(Long productId, Long storeId);
}