package com.sellfinity.core.infrastructure.api.users;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserResponse {

  private Long id;
  private String name;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}