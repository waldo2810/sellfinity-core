package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Image {

  private Long id;
  private Product product;
  private String url;
  private LocalDateTime createdAt;
}