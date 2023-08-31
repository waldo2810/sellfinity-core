package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.SaveProductService;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepository;
import com.sellfinity.core.infrastructure.repository.product.ProductRepository;
import com.sellfinity.core.infrastructure.repository.product.ProductRepositoryMapper;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryDto;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryRepository;
import com.sellfinity.core.shared.exception.notfound.category.CategoryNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveProductAdapter implements SaveProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final ProductCategoryRepository productCategoryRepository;
  private final ProductRepositoryMapper productRepositoryMapper;

  @Override
  public Product saveProduct(Product product, List<Long> categoryIds) {

    return saveProductAndItsCategories(product, categoryIds);
  }

  private Product saveProductAndItsCategories(Product product, List<Long> categoryIds) {

    Product productSave = productRepositoryMapper.toEntity(
        productRepository.save(productRepositoryMapper.toDto(product)));
    List<ProductCategoryDto> productCategoryList = new ArrayList<>();
    for (Long categoryId : categoryIds) {
      categoryRepository.findById(categoryId)
          .orElseThrow(() -> new CategoryNotFoundException(String.valueOf(categoryId)));
      ProductCategoryDto productCategory = new ProductCategoryDto();
      productCategory.setProductId(productSave.getId());
      productCategory.setCategoryId(categoryId);
      productCategory.setStoreId(productSave.getStore().getId());
      productCategoryList.add(productCategory);
    }
    productCategoryRepository.saveAll(productCategoryList);
    return productSave;
  }
}