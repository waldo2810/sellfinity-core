package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.infrastructure.api.image.ImageResponse;
import java.util.List;
import lombok.Data;

@Data
public class ProductImageResponse {

  private ProductResponse product;
  private List<ImageResponse> images;
}
