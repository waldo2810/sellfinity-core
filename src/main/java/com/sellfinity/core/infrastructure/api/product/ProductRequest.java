package com.sellfinity.core.infrastructure.api.product;

import java.util.List;
import lombok.Data;

@Data
public class ProductRequest {

  private Long storeId;
  private List<Long> categoryIds;
  private String name;
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
}