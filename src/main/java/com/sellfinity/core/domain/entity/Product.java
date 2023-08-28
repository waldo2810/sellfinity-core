package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Product {

  private Long id;
  private Store store;
  List<Category> category;
  private String name;
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;


}
