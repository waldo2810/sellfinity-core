package com.sellfinity.core.application.product;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.color.GetColorApplication;
import com.sellfinity.core.application.image.GetImageApplication;
import com.sellfinity.core.application.size.GetSizeApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.entity.ProductData;
import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.product.GetProductService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductApplication {

  private final GetProductService getProductService;
  private final GetStoreApplication getStoreApplication;
  private final GetImageApplication getImageApplication;
  private final GetCategoryApplication getCategoryApplication;
  private final GetSizeApplication getSizeApplication;
  private final GetColorApplication getColorApplication;

  public ProductData findProductById(Long idProduct) {
    Product foundProduct = getProductService.findProductById(idProduct);
    List<Image> images = getImageApplication.findAllImagesByProduct(idProduct);
    List<Category> categories = getCategoryApplication.findAllCategoriesByProduct(idProduct);
    List<Size> sizes = getSizeApplication.findAllSizesByProduct(idProduct);
    List<Color> colors = getColorApplication.findAllColorsByProduct(idProduct);

    return new ProductData(foundProduct, sizes, colors, categories, images);
  }

  public List<ProductData> findAllProducts(@Nullable Long storeId) {
    if (Objects.nonNull(storeId)) {
      getStoreApplication.findStoreById(storeId);
      List<Product> products = getProductService.findAllProductsByStoreId(storeId);
      return buildProductData(products);
    }
    List<Product> products = getProductService.findAllProducts();
    return buildProductData(products);
  }

  public List<Product> findAllProductsBySize(Long sizeId) {
    return getProductService.findAllProductsBySize(sizeId);
  }

  public List<Product> findAllProductsByColor(Long colorId) {
    return getProductService.findAllProductsByColor(colorId);
  }

  public List<Product> findAllProductsByCategory(Long categoryId) {
    return getProductService.findAllProductsByCategory(categoryId);
  }

  private List<ProductData> buildProductData(List<Product> products) {
    return products.stream().map(product -> {
      List<Image> images = getImageApplication.findAllImagesByProduct(product.getId());
      List<Category> categories = getCategoryApplication.findAllCategoriesByProduct(
          product.getId());
      List<Size> sizes = getSizeApplication.findAllSizesByProduct(product.getId());
      List<Color> colors = getColorApplication.findAllColorsByProduct(product.getId());
      return new ProductData(product, sizes, colors, categories, images);
    }).collect(Collectors.toList());
  }
}