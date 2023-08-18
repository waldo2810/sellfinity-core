package com.sellfinity.core.infrastructure.api.category;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CategoryResponse {

  private Long id;
  private Long name;
  private LocalDateTime createdAt;
}
