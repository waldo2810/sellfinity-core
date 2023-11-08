package com.sellfinity.core.infrastructure.adapter.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductCategory;
import com.sellfinity.core.domain.entity.ProductColor;
import com.sellfinity.core.domain.entity.ProductSize;
import com.sellfinity.core.domain.service.product.GetProductService;
import com.sellfinity.core.infrastructure.adapter.product_category.GetProductCategoryAdapter;
import com.sellfinity.core.infrastructure.adapter.product_color.GetProductColorAdapter;
import com.sellfinity.core.infrastructure.adapter.product_size.GetProductSizeAdapter;
import com.sellfinity.core.infrastructure.api.product.FindProductRequest;
import com.sellfinity.core.infrastructure.repository.product.ProductRepository;
import com.sellfinity.core.infrastructure.repository.product.ProductRepositoryMapper;
import com.sellfinity.core.infrastructure.repository.product.custom.ProductCustomRepository;
import com.sellfinity.core.shared.exception.notfound.product.ProductNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProductAdapter implements GetProductService {

  private final ProductRepository productRepository;
  private final ProductCustomRepository productCustomRepo;
  private final ProductRepositoryMapper productRepositoryMapper;
  private final GetProductSizeAdapter getProductSizeAdapter;
  private final GetProductColorAdapter getProductColorAdapter;
  private final GetProductCategoryAdapter getProductCategoryAdapter;

  @Override
  public Product findProductById(Long id) {
    return productRepositoryMapper.toEntity(productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(String.valueOf(id))));
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepositoryMapper.toEntity(productRepository.findAll());
  }

  @Override
  public List<Product> findAllProductsByStoreId(Long storeId) {
    return productRepositoryMapper.toEntity(productRepository.findAllByStore_Id(storeId));
  }

  @Override
  public List<Product> findAllProductsBySize(Long sizeId, Long storeId) {
    List<ProductSize> productSizeList = getProductSizeAdapter.findAllProductSizesBySize(sizeId,
        storeId);
    return productSizeList.stream().map(ProductSize::getProduct).collect(Collectors.toList());
  }

  @Override
  public List<Product> findAllProductsByColor(Long colorId, Long storeId) {
    List<ProductColor> productColorList = getProductColorAdapter.findAllProductColorByColor(
        colorId, storeId);
    return productColorList.stream().map(ProductColor::getProduct).collect(Collectors.toList());
  }

  @Override
  public List<Product> findAllProductsByCategory(Long categoryId, Long storeId) {
    List<ProductCategory> productCategoryList = getProductCategoryAdapter.findAllProductCategoryByCategory(
        categoryId, storeId);
    return productCategoryList.stream().map(ProductCategory::getProduct)
        .collect(Collectors.toList());
  }

  @Override
  public List<Product> findFeaturedProductsByStoreId(Long storeId) {
    return productRepositoryMapper.toEntity(productRepository.findByIsFeaturedTrue());
  }

  @Override
  public Long getProductCount(Long storeId) {
    return productRepository.count();
  }

  @Override
  public List<Product> findAllProductsCriteria(FindProductRequest req) {
    return productRepositoryMapper.toEntity(productCustomRepo.findAllProductsCriteria(req));
  }
}