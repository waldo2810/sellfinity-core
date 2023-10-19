package com.sellfinity.core.domain.entity;

import lombok.Data;

@Data
public class ProductColor {

  private Long id;
  private Product product;
  private Color color;
  private Store store;
}
