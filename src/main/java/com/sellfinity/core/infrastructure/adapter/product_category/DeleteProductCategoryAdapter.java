package com.sellfinity.core.infrastructure.adapter.product_category;

import com.sellfinity.core.domain.service.product_category.DeleteProductCategoryService;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductCategoryAdapter implements DeleteProductCategoryService {

  private final ProductCategoryRepository productCategoryRepository;

  @Override
  public void deleteProductCategory(Long productId, Long storeId) {
    productCategoryRepository.deleteByProductIdAndStoreId(productId, storeId);
  }
}