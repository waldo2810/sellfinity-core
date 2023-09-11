package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.domain.entity.Store;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductResponse {

  private Long id;
  private Store store;
  private String name;
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}