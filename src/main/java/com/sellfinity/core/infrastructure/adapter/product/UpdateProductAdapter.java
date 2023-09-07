package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.UpdateProductService;
import com.sellfinity.core.infrastructure.repository.product.ProductRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProductAdapter implements UpdateProductService {

  private final ProductRepository productRepository;


  @Override
  public void updateProduct(Long id, Long idStore, Product product, List<Long> categoryIds) {
    productRepository.updateProduct(id, idStore, product.getName(), product.getPrice(),
        product.getIsFeatured(), product.getIsArchived());
  }


}