package com.sellfinity.core.infrastructure.api.billboard;

import lombok.Data;

@Data
public class BillboardRequest {

  private Long storeId;
  private Long categoryId;
  private String label;
  private String imageUrl;
}