package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.UpdateProductService;
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
public class UpdateProductAdapter implements UpdateProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final ProductCategoryRepository productCategoryRepository;
  private final ProductRepositoryMapper productRepositoryMapper;

  @Override
  public void updateProduct(Long id, Long idStore, Product product, List<Long> categoryIds) {
    updateProductAndCategories(id, idStore, product, categoryIds);
  }

  private void updateProductAndCategories(Long id, Long idStore, Product product,
      List<Long> categoryIds) {
    productRepository.updateProduct(id, idStore, product.getName(), product.getPrice(),
        product.getIsFeatured(), product.getIsArchived());
    productCategoryRepository.deleteByProductIdAndStoreId(id, idStore);
    List<ProductCategoryDto> productCategoryList = updateCategories(
        id, idStore, categoryIds);
    productCategoryRepository.saveAll(productCategoryList);
  }

  private List<ProductCategoryDto> updateCategories(Long id, Long idStore,
      List<Long> categoryIds) {
    List<ProductCategoryDto> productCategoryList = new ArrayList<>();
    for (Long categoryId : categoryIds) {
      categoryRepository.findById(categoryId)
          .orElseThrow(() -> new CategoryNotFoundException(String.valueOf(categoryId)));
      ProductCategoryDto productCategory = new ProductCategoryDto();
      productCategory.setProductId(id);
      productCategory.setCategoryId(categoryId);
      productCategory.setStoreId(idStore);
      productCategoryList.add(productCategory);
    }
    return productCategoryList;
  }
}