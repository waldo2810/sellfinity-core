package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.infrastructure.api.category.CategoryResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class ProductResponse {

  private Long id;
  private String name;
  private List<CategoryResponse> category;
  private LocalDateTime createdAt;
}
