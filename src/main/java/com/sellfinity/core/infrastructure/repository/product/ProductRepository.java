package com.sellfinity.core.infrastructure.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDto, Long> {

}
