package com.sellfinity.core.application.color.validator;

import com.sellfinity.core.application.color.GetColorApplication;
import com.sellfinity.core.application.product.GetProductApplication;
import com.sellfinity.core.shared.exception.conflict.color.ColorBelongsToProductException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteColorValidator {

  private final GetColorApplication getColorApplication;
  private final GetProductApplication getProductApplication;

  public void validateColor(Long colorId) {
    getColorApplication.findColorById(colorId);
    if (isRelatedToProducts(colorId)) {
      throw new ColorBelongsToProductException(String.valueOf(colorId));
    }
  }

  private boolean isRelatedToProducts(Long colorId) {
    return getProductApplication.findAllProductsByColor(colorId).size() > 0;
  }
}
