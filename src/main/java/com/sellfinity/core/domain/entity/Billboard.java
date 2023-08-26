package com.sellfinity.core.domain.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Billboard {

  private Long id;
  private Store store;
  private Category category;
  private String label;
  private String imageUrl;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;
}
