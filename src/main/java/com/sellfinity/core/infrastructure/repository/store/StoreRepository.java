package com.sellfinity.core.infrastructure.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreDto, Long> {
  @Modifying
  @Query("UPDATE StoreDto s SET s.name = :name, s.updatedAt = CURRENT_TIMESTAMP WHERE s.id = :id")
  void updateStore(@Param("id") Long id, @Param("name") String name);
}
