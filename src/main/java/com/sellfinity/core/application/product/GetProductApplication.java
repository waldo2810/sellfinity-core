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
import com.sellfinity.core.infrastructure.api.product.FindProductRequest;
import java.util.ArrayList;
import java.util.List;
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


  public List<ProductData> findAllProductsCriteria(FindProductRequest req) {
    return buildProductData(getProductService.findAllProductsCriteria(req));
  }

  public List<ProductData> findAllProducts(FindProductRequest req) {
    Boolean isFeatured = req.getIsFeatured();
    Long storeId = req.getStoreId();
    Long categoryId = req.getCategoryId();
    Long sizeId = req.getSizeId();
    Long colorId = req.getColorId();

    if (storeId != null) {
      getStoreApplication.findStoreById(req.getStoreId());
      List<Product> collectedProducts = new ArrayList<>();

      if (isFeatured != null) {
        List<Product> featuredProducts = getProductService.findFeaturedProductsByStoreId(
            req.getStoreId());
        return buildProductData(featuredProducts);
      }
      if (categoryId != null) {
        List<Product> productsByCategory = getProductService.findAllProductsByCategory(categoryId,
            storeId);
        collectedProducts.addAll(productsByCategory);
//        return buildProductData(productsByCategory);
      }
      if (sizeId != null) {
        List<Product> productsBySize = getProductService.findAllProductsBySize(sizeId, storeId);
        collectedProducts.addAll(productsBySize);
//        return buildProductData(productsBySize);
      }
      if (colorId != null) {
        List<Product> productsByColor = getProductService.findAllProductsByColor(colorId,
            storeId);
        collectedProducts.addAll(productsByColor);
//        return buildProductData(productsByColor);
      }

      if (!collectedProducts.isEmpty()) {
        return buildProductData(collectedProducts);
      } else {
        List<Product> products = getProductService.findAllProductsByStoreId(storeId);
        return buildProductData(products);
      }
    }
    List<Product> products = getProductService.findAllProducts();
    return buildProductData(products);
  }

  public List<Product> findAllProductsBySize(Long sizeId, Long storeId) {
    return getProductService.findAllProductsBySize(sizeId, storeId);
  }

  public List<Product> findAllProductsByColor(Long colorId, Long storeId) {
    return getProductService.findAllProductsByColor(colorId, storeId);
  }

  public List<Product> findAllProductsByCategory(Long categoryId, Long storeId) {
    return getProductService.findAllProductsByCategory(categoryId, storeId);
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

  public Long getProductCount(Long storeId) {
    return getProductService.getProductCount(storeId);
  }
}