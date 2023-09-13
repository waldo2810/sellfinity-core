package com.sellfinity.core.infrastructure.adapter.product_size;

import com.sellfinity.core.domain.service.product_size.DeleteProductSizeService;
import com.sellfinity.core.infrastructure.repository.product_size.ProductSizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductSizeAdapter implements DeleteProductSizeService {

  private final ProductSizeRepository productSizeRepository;

  @Override
  public void deleteProductSize(Long productId, Long storeId) {
    productSizeRepository.deleteByProductIdAndStoreId(productId, storeId);
  }

  @Override
  public void deleteAllProductSizesByProductId(Long id) {
    productSizeRepository.deleteAllByProduct_Id(id);
  }
}