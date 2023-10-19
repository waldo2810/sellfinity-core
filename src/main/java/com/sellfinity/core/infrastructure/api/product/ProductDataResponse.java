package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.infrastructure.api.category.CategoryResponse;
import com.sellfinity.core.infrastructure.api.color.ColorResponse;
import com.sellfinity.core.infrastructure.api.image.ImageResponse;
import com.sellfinity.core.infrastructure.api.size.SizeResponse;
import java.util.List;
import lombok.Data;

@Data
public class ProductDataResponse {

  private ProductResponse product;
  private List<SizeResponse> sizes;
  private List<ColorResponse> colors;
  private List<CategoryResponse> categories;
  private List<ImageResponse> images;
}
