package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Category {

  private Long id;
  private Long billboardId;
  private String name;
  private String products;
  private Store store;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
