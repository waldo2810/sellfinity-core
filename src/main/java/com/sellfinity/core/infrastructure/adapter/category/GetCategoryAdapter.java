package com.sellfinity.core.infrastructure.adapter.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.category.GetCategoryService;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepository;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.category.CategoryNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetCategoryAdapter implements GetCategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryRepositoryMapper categoryRepositoryMapper;

  @Override
  public List<Category> findAllCategories() {
    return categoryRepositoryMapper.toEntity(categoryRepository.findAll());
  }

  @Override
  public Category findCategoryById(Long id) {
    return categoryRepositoryMapper.toEntity(categoryRepository.findById(id)
        .orElseThrow(() -> new CategoryNotFoundException(String.valueOf(id))));
  }

  @Override
  public List<Category> findAllCategoriesByStoreId(Long storeId) {
    return categoryRepositoryMapper.toEntity(categoryRepository.findByStore_Id(storeId));
  }
}
