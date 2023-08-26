package com.sellfinity.core.infrastructure.repository.billboard;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillboardRepository extends JpaRepository<BillboardDto, Long> {

  @Modifying
  @Query("UPDATE BillboardDto b SET b.store.id = ?2, b.category.id = ?3, b.label = ?4,"
      + "b.imageUrl = ?5,b.updateAt = ?6 WHERE b.id = ?1 ")
  void updateBillboard(Long id, Long storeId, Long categoryId, String label, String imageUrl,
      LocalDateTime updateAt);
}
