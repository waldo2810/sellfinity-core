package com.sellfinity.core.infrastructure.adapter.color;

import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.service.color.UpdateColorService;
import com.sellfinity.core.infrastructure.repository.color.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateColorAdapter implements UpdateColorService {

  private final ColorRepository colorRepository;

  @Override
  public void updateColor(Long id, Color color) {
    colorRepository.updateColor(id, color.getName(), color.getValue(),
        color.getUpdatedAt());
  }
}
