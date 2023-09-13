package com.sellfinity.core.infrastructure.repository.product_category;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryDto, Long> {

  @Modifying
  @Query("DELETE FROM ProductCategoryDto pc WHERE pc.product.id = :productId AND pc.store.id = :storeId")
  void deleteByProductIdAndStoreId(Long productId, Long storeId);

  List<ProductCategoryDto> findAllByCategory_Id(Long catId);

  List<ProductCategoryDto> findAllByProduct_Id(Long id);
}