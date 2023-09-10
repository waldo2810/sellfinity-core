package com.sellfinity.core.infrastructure.api.size;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SizeRequest {

  @NotNull(message = "A category must have a name")
  private String name;
  @NotNull(message = "A category must have a value")
  private String value;
  @NotNull(message = "A category must belong to a store")
  private Long storeId;
}