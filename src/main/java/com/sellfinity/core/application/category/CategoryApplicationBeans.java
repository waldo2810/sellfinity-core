package com.sellfinity.core.application.category;

import com.sellfinity.core.application.category.validator.DeleteCategoryValidator;
import com.sellfinity.core.application.product.GetProductApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.service.category.DeleteCategoryService;
import com.sellfinity.core.domain.service.category.GetCategoryService;
import com.sellfinity.core.domain.service.category.SaveCategoryService;
import com.sellfinity.core.domain.service.category.UpdateCategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryApplicationBeans {

  @Bean
  public GetCategoryApplication createGetCategoryApplication(
      GetCategoryService getCategoryService, GetStoreApplication getStoreApplication) {
    return new GetCategoryApplication(getCategoryService, getStoreApplication);
  }

  @Bean
  public SaveCategoryApplication createSaveCategoryApplication(
      SaveCategoryService saveCategoryService) {
    return new SaveCategoryApplication(saveCategoryService);
  }

  @Bean
  public DeleteCategoryApplication createDeleteCategoryApplication(
      DeleteCategoryService deleteCategoryService,
      DeleteCategoryValidator deleteCategoryValidator) {
    return new DeleteCategoryApplication(deleteCategoryService, deleteCategoryValidator);
  }

  @Bean
  public UpdateCategoryApplication createUpdateCategoryApplication(
      UpdateCategoryService updateCategoryService, GetCategoryApplication getCategoryApplication) {
    return new UpdateCategoryApplication(updateCategoryService, getCategoryApplication);
  }

  @Bean
  public DeleteCategoryValidator createDeleteCategoryValidator(
      GetCategoryApplication getCategoryApplication, GetProductApplication getProductApplication) {
    return new DeleteCategoryValidator(getCategoryApplication, getProductApplication);
  }
}
