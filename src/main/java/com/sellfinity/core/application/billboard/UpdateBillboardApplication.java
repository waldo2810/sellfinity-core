package com.sellfinity.core.application.billboard;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.service.billboard.UpdateBillBoardService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateBillboardApplication {

  private final UpdateBillBoardService updateCategoryService;
  private final GetBillboardApplication getBillboardApplication;
  private final GetStoreApplication getStoreApplication;
  private final GetCategoryApplication getCategoryApplication;

  @Transactional
  public void updateBillboard(Long id, Billboard billboard) {
    getCategoryApplication.findCategoryById(billboard.getCategory().getId());
    getStoreApplication.findStoreById(billboard.getStore().getId());
    getBillboardApplication.findBillBoardById(id);
    billboard.setUpdateAt(LocalDateTime.now());
    updateCategoryService.updateBillBoard(id, billboard);
  }
}
