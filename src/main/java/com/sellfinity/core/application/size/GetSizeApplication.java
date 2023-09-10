package com.sellfinity.core.application.size;

import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.size.GetSizeService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetSizeApplication {

  private final GetSizeService getSizeService;
  private final GetStoreApplication getStoreApplication;

  public List<Size> findAllSizes(@Nullable Long storeId) {
    if (Objects.nonNull(storeId)) {
      getStoreApplication.findStoreById(storeId);
      return getSizeService.findAllSizesByStoreId(storeId);
    }
    return getSizeService.findAllSizes();
  }

  public Size findSizeById(Long id) {
    return getSizeService.findSizeById(id);
  }
}
