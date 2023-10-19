package com.sellfinity.core.infrastructure.adapter.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.service.billboard.UpdateBillBoardService;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateBillboardAdapter implements UpdateBillBoardService {

  private final BillboardRepository billboardRepository;

  @Override
  public void updateBillBoard(Long id, Billboard billBoard) {
    billboardRepository.updateBillboard(id, billBoard.getStore().getId(),
        billBoard.getCategory().getId(), billBoard.getLabel()
        , billBoard.getImageUrl(), billBoard.getUpdateAt());
  }
}
