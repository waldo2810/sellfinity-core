package com.sellfinity.core.infrastructure.repository.category;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDto, Long> {

  List<CategoryDto> findByStore_Id(Long storeId);

  @Modifying
  @Query("UPDATE CategoryDto cat SET cat.name = :name, cat.updatedAt = :updatedAt WHERE cat.id = :id")
  void updateCategory(Long id, String name, LocalDateTime updatedAt);
}
