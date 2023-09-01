package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.service.product.DeleteProductService;
import com.sellfinity.core.infrastructure.repository.product.ProductRepository;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductAdapter implements DeleteProductService {

  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;

  @Override
  public void deleteProduct(Long id, Long idStore) {
    productRepository.deleteByIdAndStoreId(id, idStore);
    productCategoryRepository.deleteByProductIdAndStoreId(id, idStore);
  }
}