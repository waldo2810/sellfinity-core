package com.sellfinity.core.application.billboard;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.service.billboard.GetBillBoardService;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetBillboardApplication {

  private final GetBillBoardService getBillBoardService;
  private final GetStoreApplication getStoreApplication;
  private final GetCategoryApplication getCategoryApplication;

  public List<Billboard> findAllBillboards(@Nullable Long storeId, @Nullable Long categoryId) {
    if (Objects.nonNull(storeId)) {
      getStoreApplication.findStoreById(storeId);
      return getBillBoardService.findAllBillboardsByStoreId(storeId);
    }
    if (Objects.nonNull(categoryId)) {
      getCategoryApplication.findCategoryById(categoryId);
      return getBillBoardService.findAllBillboardsByCategoryId(categoryId);
    }
    return getBillBoardService.findAllBillBoards();
  }

  public Billboard findBillBoardById(Long id) {
    return getBillBoardService.findBillBoardById(id);
  }
}
