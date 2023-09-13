package com.sellfinity.core.domain.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductData {

  private Product product;
  private List<Size> sizes;
  private List<Color> colors;
  private List<Category> categories;
  private List<Image> images;
}
