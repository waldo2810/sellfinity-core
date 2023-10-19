package com.sellfinity.core.infrastructure.adapter.size;

import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.size.SaveSizeService;
import com.sellfinity.core.infrastructure.repository.size.SizeRepository;
import com.sellfinity.core.infrastructure.repository.size.SizeRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveSizeAdapter implements SaveSizeService {

  private final SizeRepository sizeRepository;
  private final SizeRepositoryMapper sizeRepositoryMapper;

  @Override
  public Size saveSize(Size size) {
    return sizeRepositoryMapper.toEntity(
        sizeRepository.save(sizeRepositoryMapper.toDto(size)));
  }
}
