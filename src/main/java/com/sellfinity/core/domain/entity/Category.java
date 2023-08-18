package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Category {

  private Long id;
  private Long billboardId;
  private String name;
  /*private CategoryProduct products;*/
  private String products;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
