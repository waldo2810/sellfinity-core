package com.sellfinity.core.infrastructure.adapter.product_color;

import com.sellfinity.core.domain.entity.ProductColor;
import com.sellfinity.core.infrastructure.repository.product_color.ProductColorRepository;
import com.sellfinity.core.infrastructure.repository.product_color.ProductColorRepositoryMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProductColorAdapter {

  private final ProductColorRepository productSizeRepository;
  private final ProductColorRepositoryMapper productSizeRepositoryMapper;

  public List<ProductColor> findAllProductColorByColor(Long colorId) {
    return productSizeRepositoryMapper.toEntity(productSizeRepository.findAllByColor_Id(colorId));
  }
}
