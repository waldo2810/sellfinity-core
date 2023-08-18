package com.sellfinity.core.domain.service.category;

import com.sellfinity.core.domain.entity.Category;
import java.util.List;

public interface GetCategoryService {

  List<Category> findAllCategories();

  Category findCategoryById(Long id);
}
