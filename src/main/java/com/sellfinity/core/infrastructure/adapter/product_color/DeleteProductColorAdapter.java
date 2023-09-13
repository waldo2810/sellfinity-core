package com.sellfinity.core.infrastructure.adapter.product_color;

import com.sellfinity.core.domain.service.product_color.DeleteProductColorService;
import com.sellfinity.core.infrastructure.repository.product_color.ProductColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductColorAdapter implements DeleteProductColorService {

  private final ProductColorRepository productColorRepository;

  @Override
  public void deleteProductColor(Long productId, Long storeId) {
    productColorRepository.deleteByProductIdAndStoreId(productId, storeId);
  }

  @Override
  public void deleteAllProductColorsByProductId(Long id) {
    productColorRepository.deleteAllByProduct_Id(id);
  }
}