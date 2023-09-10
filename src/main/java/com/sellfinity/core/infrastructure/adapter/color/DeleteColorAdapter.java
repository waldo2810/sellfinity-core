package com.sellfinity.core.infrastructure.adapter.color;

import com.sellfinity.core.domain.service.color.DeleteColorService;
import com.sellfinity.core.infrastructure.repository.color.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteColorAdapter implements DeleteColorService {

  private final ColorRepository colorRepository;

  @Override
  public void deleteColor(Long id) {
    colorRepository.deleteById(id);
  }
}
