package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.infrastructure.api.category.CategoryRequest;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper
public interface ProductRequestMapper {
  @Mapping(target = "store.id", source = "storeId")
  @Mapping(target = "category", expression = "java(mapCategoryIdsToCategories(productRequest.getCategoryId()))")
  Product toEntity(ProductRequest productRequest);
  default List<Category> mapCategoryIdsToCategories(List<Long> categoryIds) {
    List<Category> categories = new ArrayList<>();
    for (Long categoryId : categoryIds) {
      Category category = new Category();
      category.setId(categoryId);
      categories.add(category);
    }
    return categories;

  }

}
