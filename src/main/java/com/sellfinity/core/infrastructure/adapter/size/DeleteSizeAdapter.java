package com.sellfinity.core.infrastructure.adapter.size;

import com.sellfinity.core.domain.service.size.DeleteSizeService;
import com.sellfinity.core.infrastructure.repository.size.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteSizeAdapter implements DeleteSizeService {

  private final SizeRepository sizeRepository;

  @Override
  public void deleteSize(Long id) {
    sizeRepository.deleteById(id);
  }
}
