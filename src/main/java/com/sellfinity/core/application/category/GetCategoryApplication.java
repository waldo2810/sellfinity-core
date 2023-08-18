package com.sellfinity.core.application.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.GetCategoryService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCategoryApplication {

  private final GetCategoryService getCategoryService;

  public List<Category> findAllCategories() {
    return getCategoryService.findAllCategories();
  }

  public Category findCategoryById(Long id) {
    return getCategoryService.findCategoryById(id);
  }
}
