package com.sellfinity.core.domain.entity;

import lombok.Data;

@Data
public class ProductSize {

  private Long id;
  private Product product;
  private Size size;
  private Store store;
}
