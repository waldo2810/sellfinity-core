package com.sellfinity.core.infrastructure.api.billboard;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BillboardRequest {

  @NotNull
  private Long storeId;
  @NotNull
  private Long categoryId;
  @NotNull
  private String label;
  private String imageUrl;
}
