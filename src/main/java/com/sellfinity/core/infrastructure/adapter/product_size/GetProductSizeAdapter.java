package com.sellfinity.core.infrastructure.adapter.product_size;

import com.sellfinity.core.domain.entity.ProductSize;
import com.sellfinity.core.domain.service.product_size.GetProductSizeService;
import com.sellfinity.core.infrastructure.repository.product_size.ProductSizeRepository;
import com.sellfinity.core.infrastructure.repository.product_size.ProductSizeRepositoryMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProductSizeAdapter implements GetProductSizeService {

  private final ProductSizeRepository productSizeRepository;
  private final ProductSizeRepositoryMapper productSizeRepositoryMapper;

  @Override
  public List<ProductSize> findAllProductSizesBySize(Long sizeId, Long storeId) {
    return productSizeRepositoryMapper.toEntity(
        productSizeRepository.findAllBySize_IdAndStore_Id(sizeId, storeId));
  }

  @Override
  public List<ProductSize> findAllProductSizesByProduct(Long id) {
    return productSizeRepositoryMapper.toEntity(productSizeRepository.findAllByProduct_Id(id));
  }
}
