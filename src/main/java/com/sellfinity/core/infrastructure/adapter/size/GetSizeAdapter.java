package com.sellfinity.core.infrastructure.adapter.size;

import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.size.GetSizeService;
import com.sellfinity.core.infrastructure.repository.size.SizeRepository;
import com.sellfinity.core.infrastructure.repository.size.SizeRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.size.SizeNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetSizeAdapter implements GetSizeService {

  private final SizeRepository sizeRepository;
  private final SizeRepositoryMapper sizeRepositoryMapper;

  @Override
  public List<Size> findAllSizes() {
    return sizeRepositoryMapper.toEntity(sizeRepository.findAll());
  }

  @Override
  public Size findSizeById(Long id) {
    return sizeRepositoryMapper.toEntity(sizeRepository.findById(id)
        .orElseThrow(() -> new SizeNotFoundException(String.valueOf(id))));
  }

  @Override
  public List<Size> findAllSizesByStoreId(Long storeId) {
    return sizeRepositoryMapper.toEntity(sizeRepository.findByStore_Id(storeId));
  }
}
