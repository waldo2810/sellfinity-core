package com.sellfinity.core.infrastructure.repository.product;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductDto, Long> {

  @Modifying
  @Query("UPDATE ProductDto p SET p.name = :name, p.price = :price, p.isFeatured = :isFeatured, p.isArchived = :isArchived, p.updatedAt = CURRENT_TIMESTAMP WHERE p.id = :id AND p.store.id = :idStore")
  void updateProduct(@Param("id") Long id, @Param("idStore") Long idStore,
      @Param("name") String name, @Param("price") Double price,
      @Param("isFeatured") Boolean isFeatured, @Param("isArchived") Boolean isArchived);

  @Transactional
  void deleteByIdAndStoreId(Long id, Long storeId);

}