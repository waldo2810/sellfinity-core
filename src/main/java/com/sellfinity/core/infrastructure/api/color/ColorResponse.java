package com.sellfinity.core.infrastructure.api.color;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ColorResponse {

  private Long id;
  private String name;
  private String value;
  private LocalDateTime createdAt;
}