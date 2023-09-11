package com.sellfinity.core.infrastructure.adapter.image;

import com.sellfinity.core.domain.service.image.DeleteImageService;
import com.sellfinity.core.infrastructure.repository.image.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteImageAdapter implements DeleteImageService {

  private final ImageRepository imageRepository;

  @Override
  public void deleteImageByProductId(Long productId) {
    imageRepository.deleteAllByProduct_id(productId);
  }
}
