package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Product {

  private Long id;
  private Store store;
  private String name;
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}