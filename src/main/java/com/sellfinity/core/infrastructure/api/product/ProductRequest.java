package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.infrastructure.api.image.ImageRequest;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class ProductRequest {

  @NotNull
  private Long storeId;
  @NotNull
  private List<Long> categoryIds;
  @NotNull
  private List<Long> sizeIds;
  @NotNull
  private List<Long> colorIds;
  private List<ImageRequest> images;
  @NotNull
  private String name;
  @NotNull
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
}