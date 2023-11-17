package com.sellfinity.core.infrastructure.adapter.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.domain.service.billboard.GetBillBoardService;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepository;
import com.sellfinity.core.infrastructure.repository.billboard.BillboardRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.billboard.BillboardNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetBillboardAdapter implements GetBillBoardService {

  private final BillboardRepository billboardRepository;
  private final BillboardRepositoryMapper billboardRepositoryMapper;

  @Override
  public List<Billboard> findAllBillBoards() {
    return billboardRepositoryMapper.toEntity(billboardRepository.findAll());
  }

  @Override
  public Billboard findBillBoardById(Long id) {
    return billboardRepository.findById(id).map(billboardRepositoryMapper::toEntity)
        .orElseThrow(() -> new BillboardNotFoundException(id.toString()));
  }

  @Override
  public List<Billboard> findAllBillboardsByStoreId(Long storeId) {
    return billboardRepositoryMapper.toEntity(billboardRepository.findByStore_Id(storeId));
  }

  @Override
  public List<Billboard> findAllBillboardsByCategoryId(Long categoryId) {
    return billboardRepositoryMapper.toEntity(billboardRepository.findByCategory_Id(categoryId));
  }
}
