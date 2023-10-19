package com.sellfinity.core.infrastructure.adapter.image;

import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.service.image.SaveImageService;
import com.sellfinity.core.infrastructure.repository.image.ImageRepository;
import com.sellfinity.core.infrastructure.repository.image.ImageRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveImageAdapter implements SaveImageService {

  private final ImageRepository imageRepository;
  private final ImageRepositoryMapper imageRepositoryMapper;

  @Override
  public Image saveImage(Image image) {
    return imageRepositoryMapper.toEntity(imageRepository.save(imageRepositoryMapper.toDto(image)));
  }
}
