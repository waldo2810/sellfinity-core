package com.sellfinity.core.domain.entity;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Store {

  private Long id;
  private String name;
  private String userEmail;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
