package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Category {

  private Long id;
  private Long billboardId;
  private String name;
  private List<Product> product;
  private Store store;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}