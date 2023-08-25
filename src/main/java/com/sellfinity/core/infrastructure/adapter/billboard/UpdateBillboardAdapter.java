package com.sellfinity.core.infrastructure.adapter.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.service.billboard.UpdateBillBoardService;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardDto;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepository;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateBillboardAdapter implements UpdateBillBoardService {

  private final BillboardRepository billboardRepository;
  private final BillboardRepositoryMapper billboardRepositoryMapper;

  @Override
  public void updateBillBoard(Long id, Billboard billBoard) {
    BillboardDto billboardDto = billboardRepositoryMapper.toDto(billBoard);
    billboardRepository.save(billboardDto); //TODO USAR QUERY
  }
}
