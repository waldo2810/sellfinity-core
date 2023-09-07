package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Category {

  private Long id;
  private String name;
  private Store store;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}