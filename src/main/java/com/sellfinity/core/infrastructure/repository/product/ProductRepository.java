package com.sellfinity.core.infrastructure.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductDto, Long> {

  @Modifying(clearAutomatically = true)
  @Query("UPDATE ProductDto p SET p.name = :name, p.price = :price, p.isFeatured = :isFeatured, p.isArchived = :isArchived, p.updatedAt = CURRENT_TIMESTAMP WHERE p.id = :id")
  void updateProduct(Long id, String name, Double price, Boolean isFeatured, Boolean isArchived);
}