package com.sellfinity.core.infrastructure.api.product;

import lombok.Data;

@Data
public class FindProductRequest {

  private Long storeId;
  private Boolean isFeatured;
  private Boolean isArchived;
  private Long categoryId;
  private Long colorId;
  private Long sizeId;
}
