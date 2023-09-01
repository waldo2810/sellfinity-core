package com.sellfinity.core.infrastructure.api.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequest {

  @NotNull(message = "A category must have a name")
  private String name;
  @NotNull(message = "A category must belong to a store")
  private Long storeId;
}