package com.sellfinity.core.infrastructure.repository.store;

import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreDto, Long> {

}
