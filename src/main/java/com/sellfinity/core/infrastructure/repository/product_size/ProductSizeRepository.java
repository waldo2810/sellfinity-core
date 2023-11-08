package com.sellfinity.core.infrastructure.repository.product_size;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductSizeRepository extends JpaRepository<ProductSizeDto, Long> {

  @Modifying
  @Query("DELETE FROM ProductSizeDto pc WHERE pc.product.id = :productId AND pc.store.id = :storeId")
  void deleteByProductIdAndStoreId(Long productId, Long storeId);

  List<ProductSizeDto> findAllByProduct_Id(Long id);

  void deleteAllByProduct_Id(Long id);

  List<ProductSizeDto> findAllBySize_IdAndStore_Id(Long sizeId, Long storeId);
}