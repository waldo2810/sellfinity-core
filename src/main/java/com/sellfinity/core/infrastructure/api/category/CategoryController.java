package com.sellfinity.core.infrastructure.api.category;

import com.sellfinity.core.application.category.DeleteCategoryApplication;
import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.category.SaveCategoryApplication;
import com.sellfinity.core.application.category.UpdateCategoryApplication;
import com.sellfinity.core.domain.entity.Category;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

  private final GetCategoryApplication getCategoryApplication;
  private final SaveCategoryApplication saveCategoryApplication;
  private final DeleteCategoryApplication deleteCategoryApplication;
  private final UpdateCategoryApplication updateCategoryApplication;
  private final CategoryResponseMapper categoryResponseMapper;
  private final CategoryRequestMapper categoryRequestMapper;

  @GetMapping
  public ResponseEntity<List<CategoryResponse>> findAllCategories() {
    return ResponseEntity.ok(
        categoryResponseMapper.toDto(getCategoryApplication.findAllCategories()));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        categoryResponseMapper.toDto(getCategoryApplication.findCategoryById(id)));
  }

  @PostMapping
  public ResponseEntity<CategoryResponse> saveCategory(
      @Valid @RequestBody CategoryRequest category) {
    return ResponseEntity.ok(
        categoryResponseMapper.toDto(
            saveCategoryApplication.saveCategory(categoryRequestMapper.toEntity(category))));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteCategory(@PathVariable("id") Long id) {
    deleteCategoryApplication.deleteCategory(id);
  }

  @PutMapping("/update/{id}")
  public void updateCategory(@PathVariable("id") Long id,
      @RequestBody CategoryRequest categoryRequest) {
    Category category = categoryRequestMapper.toEntity(categoryRequest);
    updateCategoryApplication.updateCategory(id, category);
  }
}
