package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.GetProductService;
import com.sellfinity.core.infrastructure.repository.product.ProductRepository;
import com.sellfinity.core.infrastructure.repository.product.ProductRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.product.ProductNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProductAdapter implements GetProductService {

  private final ProductRepository productRepository;
  private final ProductRepositoryMapper productRepositoryMapper;

  @Override
  public Product findProductById(Long id) {
    return productRepositoryMapper.toEntity(productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(String.valueOf(id))));
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepositoryMapper.toEntity(productRepository.findAll());
  }

}