package com.sellfinity.core.application.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.service.billboard.GetBillBoardService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetBillboardApplication {

  private final GetBillBoardService getBillBoardService;

  public List<Billboard> findAllBillboards() {
    return getBillBoardService.findAllBillBoards();
  }

  public Billboard findBillBoardById(Long id) {
    return getBillBoardService.findBillBoardById(id);
  }
}
