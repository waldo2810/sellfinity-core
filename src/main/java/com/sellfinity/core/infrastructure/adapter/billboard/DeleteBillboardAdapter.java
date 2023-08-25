package com.sellfinity.core.infrastructure.adapter.billboard;

import com.sellfinity.core.domain.service.billboard.DeleteBillBoardService;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteBillboardAdapter implements DeleteBillBoardService {

  private final BillboardRepository billboardRepository;

  @Override
  public void deleteBillBoard(Long id) {
    billboardRepository.deleteById(id);
  }
}
