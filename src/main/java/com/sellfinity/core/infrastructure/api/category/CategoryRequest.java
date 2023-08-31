package com.sellfinity.core.infrastructure.api.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequest {

  @NotNull(message = "A category must have a name")
  private String name;
  private Long billboardId;
  private Long storeId;
}