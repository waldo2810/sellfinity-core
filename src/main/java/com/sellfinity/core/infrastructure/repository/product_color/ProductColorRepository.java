package com.sellfinity.core.infrastructure.repository.product_color;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductColorRepository extends JpaRepository<ProductColorDto, Long> {

  @Modifying
  @Query("DELETE FROM ProductColorDto pc WHERE pc.product.id = :productId AND pc.store.id = :storeId")
  void deleteByProductIdAndStoreId(Long productId, Long storeId);

  List<ProductColorDto> findAllByProduct_Id(Long id);

  void deleteAllByProduct_Id(Long id);

  List<ProductColorDto> findAllByColor_IdAndStore_Id(Long colorId, Long storeId);
}