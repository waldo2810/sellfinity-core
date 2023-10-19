package com.sellfinity.core.application.color;

import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.service.color.GetColorService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetColorApplication {

  private final GetColorService getColorService;
  private final GetStoreApplication getStoreApplication;

  public List<Color> findAllColors(@Nullable Long storeId) {
    if (Objects.nonNull(storeId)) {
      getStoreApplication.findStoreById(storeId);
      return getColorService.findAllColorsByStoreId(storeId);
    }
    return getColorService.findAllColors();
  }

  public Color findColorById(Long id) {
    return getColorService.findColorById(id);
  }

  public List<Color> findAllColorsByProduct(Long id) {
    return getColorService.findAllByProductId(id);
  }
}
