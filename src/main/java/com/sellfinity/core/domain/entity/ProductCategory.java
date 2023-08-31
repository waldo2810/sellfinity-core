package com.sellfinity.core.domain.entity;

import lombok.Data;

@Data
public class ProductCategory {

  private Long id;
  private Long productId;
  private Long categoryId;
  private Long storeId;
}