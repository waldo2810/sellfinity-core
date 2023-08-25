package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Users {

  private Long id;
  private String name;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
