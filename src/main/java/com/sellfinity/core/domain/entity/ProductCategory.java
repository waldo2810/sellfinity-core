package com.sellfinity.core.domain.entity;

import lombok.Data;

@Data
public class ProductCategory {

  private Long id;
  private Product product;
  private Category category;
  private Store store;
}