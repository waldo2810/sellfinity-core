package com.sellfinity.core.infrastructure.repository.size;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<SizeDto, Long> {

  List<SizeDto> findByStore_Id(Long storeId);

  @Modifying
  @Query("UPDATE SizeDto c SET c.name = :name, c.value = :value, c.updatedAt = :updatedAt WHERE c.id = :id")
  void updateSize(Long id, String name, String value, LocalDateTime updatedAt);
}
