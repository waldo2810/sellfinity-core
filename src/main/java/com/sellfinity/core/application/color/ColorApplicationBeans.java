package com.sellfinity.core.application.color;

import com.sellfinity.core.application.color.validator.DeleteColorValidator;
import com.sellfinity.core.application.product.GetProductApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.service.color.DeleteColorService;
import com.sellfinity.core.domain.service.color.GetColorService;
import com.sellfinity.core.domain.service.color.SaveColorService;
import com.sellfinity.core.domain.service.color.UpdateColorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColorApplicationBeans {

  @Bean
  public GetColorApplication createGetColorApplication(
      GetColorService getColorService, GetStoreApplication getStoreApplication) {
    return new GetColorApplication(getColorService, getStoreApplication);
  }

  @Bean
  public SaveColorApplication createSaveColorApplication(
      SaveColorService saveColorService) {
    return new SaveColorApplication(saveColorService);
  }

  @Bean
  public DeleteColorApplication createDeleteColorApplication(
      DeleteColorService deleteColorService, DeleteColorValidator deleteColorValidator) {
    return new DeleteColorApplication(deleteColorService, deleteColorValidator);
  }

  @Bean
  public UpdateColorApplication createUpdateColorApplication(
      UpdateColorService updateColorService, GetColorApplication getColorApplication) {
    return new UpdateColorApplication(updateColorService, getColorApplication);
  }

  @Bean
  public DeleteColorValidator createDeleteColorValidator(GetColorApplication getColorApplication,
      GetProductApplication getProductApplication) {
    return new DeleteColorValidator(getColorApplication, getProductApplication);
  }
}
