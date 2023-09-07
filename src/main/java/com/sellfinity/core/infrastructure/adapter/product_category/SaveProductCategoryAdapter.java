package com.sellfinity.core.infrastructure.adapter.product_category;

import com.sellfinity.core.domain.entity.ProductCategory;
import com.sellfinity.core.domain.service.product_category.SaveProductCategoryService;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryRepository;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveProductCategoryAdapter implements SaveProductCategoryService {

  private final ProductCategoryRepository productCategoryRepository;
  private final ProductCategoryRepositoryMapper productCategoryRepositoryMapper;

  @Override
  public ProductCategory saveProductCategory(ProductCategory productCategory) {
    return productCategoryRepositoryMapper.toEntity(
        productCategoryRepository.save(productCategoryRepositoryMapper.toDto(productCategory)));
  }
}