package com.sellfinity.core.application.category;

import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.GetCategoryService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCategoryApplication {

  private final GetCategoryService getCategoryService;
  private final GetStoreApplication getStoreApplication;

  public List<Category> findAllCategories(@Nullable Long storeId) {
    if (Objects.nonNull(storeId)){
      getStoreApplication.findStoreById(storeId);
      return getCategoryService.findAllCategoriesByStoreId(storeId);
    }
    return getCategoryService.findAllCategories();
  }

  public Category findCategoryById(Long id) {
    return getCategoryService.findCategoryById(id);
  }
}
