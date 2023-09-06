package com.sellfinity.core.infrastructure.repository.category;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDto, Long> {

  List<CategoryDto> findByStore_Id(Long storeId);
}
