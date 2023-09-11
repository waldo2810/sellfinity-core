package com.sellfinity.core.infrastructure.api.image;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ImageResponse {

  private Long id;
  private Long productId;
  private String url;
  private LocalDateTime createdAt;
}
