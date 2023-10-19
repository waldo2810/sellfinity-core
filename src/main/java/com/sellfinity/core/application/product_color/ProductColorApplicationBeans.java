package com.sellfinity.core.application.product_color;

import com.sellfinity.core.application.color.GetColorApplication;
import com.sellfinity.core.domain.service.product_color.DeleteProductColorService;
import com.sellfinity.core.domain.service.product_color.SaveProductColorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductColorApplicationBeans {

  @Bean
  public SaveProductColorApplication saveProductColorApplication(
      SaveProductColorService saveProductColorService, GetColorApplication getColorApplication) {
    return new SaveProductColorApplication(saveProductColorService, getColorApplication);
  }

  @Bean
  public DeleteProductColorApplication deleteProductColorApplication(
      DeleteProductColorService deleteProductColorService) {
    return new DeleteProductColorApplication(deleteProductColorService);
  }

  @Bean
  public UpdateProductColorApplication updateProductColorApplication(
      DeleteProductColorApplication deleteProductColorApplication,
      GetColorApplication getColorApplication,
      SaveProductColorApplication saveProductColorApplication) {
    return new UpdateProductColorApplication(deleteProductColorApplication, getColorApplication,
        saveProductColorApplication);
  }
}
