package com.sellfinity.core.application.category;

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
      GetCategoryService getCategoryService) {
    return new GetCategoryApplication(getCategoryService);
  }

  @Bean
  public SaveCategoryApplication createSaveCategoryApplication(
      SaveCategoryService saveCategoryService) {
    return new SaveCategoryApplication(saveCategoryService);
  }

  @Bean
  public DeleteCategoryApplication createDeleteCategoryApplication(
      DeleteCategoryService deleteCategoryService) {
    return new DeleteCategoryApplication(deleteCategoryService);
  }

  @Bean
  public UpdateCategoryApplication createUpdateCategoryApplication(
      UpdateCategoryService updateCategoryService, GetCategoryApplication getCategoryApplication) {
    return new UpdateCategoryApplication(updateCategoryService, getCategoryApplication);
  }
}
