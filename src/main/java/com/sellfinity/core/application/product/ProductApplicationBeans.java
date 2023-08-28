package com.sellfinity.core.application.product;

import com.sellfinity.core.domain.service.product.DeleteProductService;
import com.sellfinity.core.domain.service.product.GetProductService;
import com.sellfinity.core.domain.service.product.SaveProductService;
import com.sellfinity.core.domain.service.product.UpdateProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApplicationBeans {


  @Bean
  public SaveProductApplication saveProductProductApplication(
      SaveProductService saveProductService) {
    return new SaveProductApplication(saveProductService);
  }

  @Bean
  public GetProductApplication getProductApplication(
      GetProductService getProductService) {
    return new GetProductApplication(getProductService);
  }

  @Bean
  public DeleteProductApplication deleteProductApplication(
      DeleteProductService deleteProductService) {
    return new DeleteProductApplication(deleteProductService);
  }

  @Bean
  public UpdateProductApplication updateProductApplication(
      UpdateProductService updateProductService, GetProductApplication getProductApplication) {
    return new UpdateProductApplication(updateProductService, getProductApplication);
  }


}
