package com.sellfinity.core.application.billboard;

import com.sellfinity.core.domain.service.billboard.DeleteBillBoardService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteBillboardApplication {

  private final DeleteBillBoardService deleteBillBoardService;

  public void deleteBillboard(Long id) {
    deleteBillBoardService.deleteBillBoard(id);
  }
}
