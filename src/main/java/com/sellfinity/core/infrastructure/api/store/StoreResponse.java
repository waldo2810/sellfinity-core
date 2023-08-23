package com.sellfinity.core.infrastructure.api.store;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class StoreResponse {

  private Long id;
  private String name;
  private LocalDateTime createdAt;
}
