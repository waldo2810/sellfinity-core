package com.sellfinity.core.infrastructure.api.billboard;

import com.sellfinity.core.infrastructure.api.category.CategoryResponse;
import com.sellfinity.core.infrastructure.api.store.StoreResponse;
import lombok.Data;

@Data
public class BillBoardResponse {

  private Long id;
  private StoreResponse store;
  private CategoryResponse category;
  private String label;
  private String imageUrl;
}
