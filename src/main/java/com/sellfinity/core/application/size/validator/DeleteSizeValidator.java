package com.sellfinity.core.application.size.validator;

import com.sellfinity.core.application.product.GetProductApplication;
import com.sellfinity.core.application.size.GetSizeApplication;
import com.sellfinity.core.shared.exception.conflict.size.SizeBelongsToProductException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteSizeValidator {

  private final GetSizeApplication getSizeApplication;
  private final GetProductApplication getProductApplication;

  public void validateSize(Long sizeId) {
    getSizeApplication.findSizeById(sizeId);
    if (isRelatedToProducts(sizeId)) {
      throw new SizeBelongsToProductException(String.valueOf(sizeId));
    }
  }

  private boolean isRelatedToProducts(Long sizeId) {
    return getProductApplication.findAllProductsBySize(sizeId).size() > 0;
  }
}
