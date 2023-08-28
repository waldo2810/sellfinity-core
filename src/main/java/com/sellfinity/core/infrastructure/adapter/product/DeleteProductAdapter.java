package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.service.product.DeleteProductService;
import com.sellfinity.core.infrastructure.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductAdapter implements DeleteProductService {

  private final ProductRepository productRepository;

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
