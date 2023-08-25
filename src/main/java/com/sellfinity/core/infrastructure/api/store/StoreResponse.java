package com.sellfinity.core.infrastructure.api.store;

import com.sellfinity.core.infrastructure.api.users.UserResponse;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class StoreResponse {

  private Long id;
  private String name;
  private UserResponse user;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
