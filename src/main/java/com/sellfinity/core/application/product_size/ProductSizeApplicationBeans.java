package com.sellfinity.core.application.product_size;

import com.sellfinity.core.application.size.GetSizeApplication;
import com.sellfinity.core.domain.service.product_size.DeleteProductSizeService;
import com.sellfinity.core.domain.service.product_size.SaveProductSizeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductSizeApplicationBeans {

  @Bean
  public SaveProductSizeApplication saveProductSizeApplication(
      SaveProductSizeService saveProductSizeService, GetSizeApplication getSizeApplication) {
    return new SaveProductSizeApplication(saveProductSizeService, getSizeApplication);
  }

  @Bean
  public DeleteProductSizeApplication deleteProductSizeApplication(
      DeleteProductSizeService deleteProductSizeService) {
    return new DeleteProductSizeApplication(deleteProductSizeService);
  }
}
