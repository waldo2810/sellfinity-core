package com.sellfinity.core.application.product_category;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.domain.service.product_category.DeleteProductCategoryService;
import com.sellfinity.core.domain.service.product_category.SaveProductCategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductCategoryApplicationBeans {

  @Bean
  public SaveProductCategoryApplication saveProductCategoryApplication(
      SaveProductCategoryService saveProductCategoryService,
      GetCategoryApplication getCategoryApplication) {
    return new SaveProductCategoryApplication(saveProductCategoryService, getCategoryApplication);
  }

  @Bean
  public DeleteProductCategoryApplication deleteProductCategoryApplication(
      DeleteProductCategoryService deleteProductCategoryService) {
    return new DeleteProductCategoryApplication(deleteProductCategoryService);
  }
}
