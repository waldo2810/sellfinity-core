package com.sellfinity.core.infrastructure.api.product;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class ProductRequest {

  private Long id;
  @NotNull
  private Long storeId;
  @NotNull
  private List<Long> categoryIds;
  @NotNull
  private String name;
  @NotNull
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
}