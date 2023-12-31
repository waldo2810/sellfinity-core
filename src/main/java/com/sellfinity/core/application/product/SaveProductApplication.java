package com.sellfinity.core.application.product;

import com.sellfinity.core.application.image.SaveImageApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
import com.sellfinity.core.application.product_color.SaveProductColorApplication;
import com.sellfinity.core.application.product_size.SaveProductSizeApplication;
import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.domain.service.product.SaveProductService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveProductApplication {

  private final SaveProductService saveProductService;
  private final SaveProductCategoryApplication saveProductCategoryApplication;
  private final SaveProductSizeApplication saveProductSizeApplication;
  private final SaveProductColorApplication saveProductColorApplication;
  private final SaveImageApplication saveImageApplication;

  @Transactional
  public Product saveProduct(Product product, List<Long> categoryIds, List<Long> sizeIds,
      List<Long> colorIds, List<Image> images) {
    product.setCreatedAt(LocalDateTime.now());
    Product savedProduct = saveProductService.saveProduct(product);

    images.forEach(image -> {
      image.setProduct(savedProduct);
      image.setCreatedAt(LocalDateTime.now());
      saveImageApplication.saveImage(image);
    });

    saveProductCategoryApplication.saveProductAndItsCategories(categoryIds, savedProduct);
    saveProductSizeApplication.saveProductAndItsSizes(sizeIds, savedProduct);
    saveProductColorApplication.saveProductAndItsColors(colorIds, savedProduct);

    return savedProduct;
  }
}