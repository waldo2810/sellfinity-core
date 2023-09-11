package com.sellfinity.core.domain.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductImage {

  private Product product;
  private List<Image> images;
}
