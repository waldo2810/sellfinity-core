package com.sellfinity.core.infrastructure.adapter.product_category;

import com.sellfinity.core.domain.entity.ProductCategory;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryRepository;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryRepositoryMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProductCategoryAdapter {

  private final ProductCategoryRepository productCategoryRepository;
  private final ProductCategoryRepositoryMapper productCategoryRepositoryMapper;

  public List<ProductCategory> findAllProductCategoryByCategory(Long catId) {
    return productCategoryRepositoryMapper.toEntity(
        productCategoryRepository.findAllByCategory_Id(catId));
  }
}