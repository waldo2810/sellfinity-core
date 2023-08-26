package com.sellfinity.core.infrastructure.adapter.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.service.billboard.SaveBillboardService;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepository;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveBillboardAdapter implements SaveBillboardService {

  private final BillboardRepository billboardRepository;
  private final BillboardRepositoryMapper billboardRepositoryMapper;

  @Override
  public Billboard saveBillboard(Billboard billboard) {
    return billboardRepositoryMapper.toEntity(
        billboardRepository.save(billboardRepositoryMapper.toDto(billboard)));
  }
}
