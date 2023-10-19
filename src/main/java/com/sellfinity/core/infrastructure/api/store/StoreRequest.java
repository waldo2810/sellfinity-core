package com.sellfinity.core.infrastructure.api.store;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoreRequest {

  @NotNull
  private String name;
}
