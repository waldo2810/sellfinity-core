package com.sellfinity.core.application.product;

import com.sellfinity.core.domain.service.product.SaveProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApplicationBeans {


  @Bean
  public SaveProductApplication saveProductProductApplication(
      SaveProductService saveProductService) {
    return new SaveProductApplication(saveProductService);
  }


}
