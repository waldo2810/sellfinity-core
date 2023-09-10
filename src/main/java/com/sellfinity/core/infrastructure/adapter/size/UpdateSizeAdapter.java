package com.sellfinity.core.infrastructure.adapter.size;

import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.size.UpdateSizeService;
import com.sellfinity.core.infrastructure.repository.size.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateSizeAdapter implements UpdateSizeService {

  private final SizeRepository colorRepository;

  @Override
  public void updateSize(Long id, Size size) {
    colorRepository.updateSize(id, size.getName(), size.getValue(), size.getUpdatedAt());
  }
}
