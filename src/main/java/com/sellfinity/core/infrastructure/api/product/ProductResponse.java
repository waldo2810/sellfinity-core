package com.sellfinity.core.infrastructure.api.product;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductResponse {

  private Long id;
  private String name;
  private LocalDateTime createdAt;
}