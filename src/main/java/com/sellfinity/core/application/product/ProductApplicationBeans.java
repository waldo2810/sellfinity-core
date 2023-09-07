package com.sellfinity.core.application.product;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.product_category.DeleteProductCategoryApplication;
import com.sellfinity.core.application.product_category.SaveProductCategoryApplication;
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
  public SaveProductApplication saveProductProductApplication(SaveProductService saveProductService,
      GetCategoryApplication getCategoryApplication,
      SaveProductCategoryApplication saveProductCategoryApplication) {
    return new SaveProductApplication(saveProductService,
        saveProductCategoryApplication);
  }

  @Bean
  public GetProductApplication getProductApplication(
      GetProductService getProductService) {
    return new GetProductApplication(getProductService);
  }

  @Bean
  public DeleteProductApplication deleteProductApplication(
      DeleteProductService deleteProductService,
      DeleteProductCategoryApplication deleteProductCategoryApplication,
      GetStoreApplication getStoreApplication, GetProductApplication getProductApplication) {
    return new DeleteProductApplication(deleteProductService, deleteProductCategoryApplication,
        getStoreApplication, getProductApplication);
  }

  @Bean
  public UpdateProductApplication updateProductApplication(
      UpdateProductService updateProductService, GetProductApplication getProductApplication,
      SaveProductCategoryApplication saveProductCategoryApplication,
      DeleteProductCategoryApplication deleteProductCategoryApplication,
      GetStoreApplication getStoreApplication) {
    return new UpdateProductApplication(updateProductService, getProductApplication,
        deleteProductCategoryApplication, saveProductCategoryApplication, getStoreApplication);
  }
}