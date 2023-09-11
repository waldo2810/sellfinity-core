package com.sellfinity.core.infrastructure.api.image;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ImageRequest {

  private Long productId;
  @NotNull
  private String url;
}
