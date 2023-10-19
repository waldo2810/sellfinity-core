package com.sellfinity.core.application.product;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.color.GetColorApplication;
import com.sellfinity.core.application.image.DeleteImageApplication;
import com.sellfinity.core.application.image.GetImageApplication;
import com.sellfinity.core.application.image.SaveImageApplication;
import com.sellfinity.core.application.image.UpdateImageApplication;
import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
import com.sellfinity.core.application.product_color.DeleteProductColorApplication;
import com.sellfinity.core.application.product_color.SaveProductColorApplication;
import com.sellfinity.core.application.product_color.UpdateProductColorApplication;
import com.sellfinity.core.application.product_size.DeleteProductSizeApplication;
import com.sellfinity.core.application.product_size.SaveProductSizeApplication;
import com.sellfinity.core.application.product_size.UpdateProductSizeApplication;
import com.sellfinity.core.application.size.GetSizeApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.service.product.DeleteProductService;
import com.sellfinity.core.domain.service.product.GetProductService;
import com.sellfinity.core.domain.service.product.SaveProductService;
import com.sellfinity.core.domain.service.product.UpdateProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApplicationBeans {

  @Bean
  public SaveProductApplication createSaveProductApplication(SaveProductService saveProductService,
      SaveProductCategoryApplication saveProductCategoryApplication,
      SaveProductSizeApplication saveProductSizeApplication,
      SaveProductColorApplication saveProductColorApplication,
      SaveImageApplication saveImageApplication) {
    return new SaveProductApplication(saveProductService, saveProductCategoryApplication,
        saveProductSizeApplication, saveProductColorApplication, saveImageApplication);
  }

  @Bean
  public GetProductApplication getProductApplication(
      GetProductService getProductService, GetStoreApplication getStoreApplication,
      GetImageApplication getImageApplication, GetCategoryApplication getCategoryApplication,
      GetSizeApplication getSizeApplication, GetColorApplication getColorApplication) {
    return new GetProductApplication(getProductService, getStoreApplication, getImageApplication,
        getCategoryApplication, getSizeApplication, getColorApplication);
  }

  @Bean
  public DeleteProductApplication deleteProductApplication(
      DeleteProductService deleteProductService,
      DeleteProductCategoryApplication deleteProductCategoryApplication,
      DeleteProductSizeApplication deleteProductSizeApplication,
      DeleteProductColorApplication deleteProductColorApplication,
      DeleteImageApplication deleteImageApplication,
      GetImageApplication getImageApplication,
      GetProductApplication getProductApplication) {
    return new DeleteProductApplication(deleteProductService, deleteProductCategoryApplication,
        deleteProductSizeApplication, deleteProductColorApplication, deleteImageApplication,
        getImageApplication, getProductApplication);
  }

  @Bean
  public UpdateProductApplication updateProductApplication(
      UpdateProductService updateProductService, GetProductApplication getProductApplication,
      SaveProductCategoryApplication saveProductCategoryApplication,
      DeleteProductCategoryApplication deleteProductCategoryApplication,
      UpdateImageApplication updateImageApplication,
      UpdateProductSizeApplication updateProductSizeApplication,
      UpdateProductColorApplication updateProductColorApplication) {
    return new UpdateProductApplication(updateProductService, getProductApplication,
        deleteProductCategoryApplication, saveProductCategoryApplication, updateImageApplication,
        updateProductSizeApplication, updateProductColorApplication);
  }
}