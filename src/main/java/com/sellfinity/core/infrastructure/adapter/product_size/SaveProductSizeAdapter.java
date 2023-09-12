package com.sellfinity.core.infrastructure.adapter.product_size;

import com.sellfinity.core.domain.entity.ProductSize;
import com.sellfinity.core.domain.service.product_size.SaveProductSizeService;
import com.sellfinity.core.infrastructure.repository.product_size.ProductSizeRepository;
import com.sellfinity.core.infrastructure.repository.product_size.ProductSizeRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveProductSizeAdapter implements SaveProductSizeService {

  private final ProductSizeRepository productSizeRepository;
  private final ProductSizeRepositoryMapper productSizeRepositoryMapper;

  @Override
  public ProductSize saveProductSize(ProductSize productSize) {
    return productSizeRepositoryMapper.toEntity(
        productSizeRepository.save(productSizeRepositoryMapper.toDto(productSize)));
  }
}