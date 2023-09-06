package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.SaveProductService;
import com.sellfinity.core.infrastructure.repository.product.ProductRepository;
import com.sellfinity.core.infrastructure.repository.product.ProductRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveProductAdapter implements SaveProductService {

  private final ProductRepository productRepository;
  private final ProductRepositoryMapper productRepositoryMapper;

  @Override
  public Product saveProduct(Product product) {
    return productRepositoryMapper.toEntity(
        productRepository.save(productRepositoryMapper.toDto(product)));
  }
}