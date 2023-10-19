package com.sellfinity.core.infrastructure.adapter.color;

import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.service.color.SaveColorService;
import com.sellfinity.core.infrastructure.repository.color.ColorRepository;
import com.sellfinity.core.infrastructure.repository.color.ColorRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveColorAdapter implements SaveColorService {

  private final ColorRepository colorRepository;
  private final ColorRepositoryMapper colorRepositoryMapper;

  @Override
  public Color saveColor(Color color) {
    return colorRepositoryMapper.toEntity(
        colorRepository.save(colorRepositoryMapper.toDto(color)));
  }
}
