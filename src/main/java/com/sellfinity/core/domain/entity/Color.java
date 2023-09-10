package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Color {

  private Long id;
  private String name;
  private String value;
  private Store store;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}