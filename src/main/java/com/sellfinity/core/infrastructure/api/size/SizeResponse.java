package com.sellfinity.core.infrastructure.api.size;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SizeResponse {

  private Long id;
  private String name;
  private String value;
  private LocalDateTime createdAt;
}