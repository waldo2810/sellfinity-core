package com.sellfinity.core.application.billboard;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.service.billboard.SaveBillboardService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveBillboardApplication {

  private final SaveBillboardService saveBillboardService;
  private final GetCategoryApplication getCategoryApplication;

  public Billboard saveBillboard(Billboard billBoard) {

    Category category = getCategoryApplication.findCategoryById(billBoard.getCategory().getId());
    billBoard.setCategory(category);
    billBoard.setCreateAt(LocalDateTime.now());
    return saveBillboardService.saveBillboard(billBoard);
  }
}