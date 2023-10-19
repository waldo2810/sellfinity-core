package com.sellfinity.core.infrastructure.adapter.product_color;

import com.sellfinity.core.domain.entity.ProductColor;
import com.sellfinity.core.domain.service.product_color.SaveProductColorService;
import com.sellfinity.core.infrastructure.repository.product_color.ProductColorRepository;
import com.sellfinity.core.infrastructure.repository.product_color.ProductColorRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveProductColorAdapter implements SaveProductColorService {

  private final ProductColorRepository productColorRepository;
  private final ProductColorRepositoryMapper productColorRepositoryMapper;

  @Override
  public ProductColor saveProductColor(ProductColor productCategory) {
    return productColorRepositoryMapper.toEntity(
        productColorRepository.save(productColorRepositoryMapper.toDto(productCategory)));
  }
}