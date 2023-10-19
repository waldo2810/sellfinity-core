package com.sellfinity.core.infrastructure.repository.color;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorDto, Long> {

  List<ColorDto> findByStore_Id(Long storeId);

  @Modifying
  @Query("UPDATE ColorDto c SET c.name = :name, c.value = :value, c.updatedAt = :updatedAt WHERE c.id = :id")
  void updateColor(Long id, String name, String value, LocalDateTime updatedAt);
}
