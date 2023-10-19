package com.sellfinity.core.infrastructure.adapter.image;

import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.domain.service.image.GetImageService;
import com.sellfinity.core.infrastructure.repository.image.ImageRepository;
import com.sellfinity.core.infrastructure.repository.image.ImageRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.image.ImageNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetImageAdapter implements GetImageService {

  private final ImageRepository imageRepository;
  private final ImageRepositoryMapper imageRepositoryMapper;

  @Override
  public List<Image> findAllImagesByProduct(Long productId) {
    return imageRepositoryMapper.toEntity(imageRepository.findAllByProduct_Id(productId));
  }

  @Override
  public Image findImageById(Long id) {
    return imageRepositoryMapper.toEntity(
        imageRepository.findById(id)
            .orElseThrow(() -> new ImageNotFoundException(String.valueOf(id))));
  }
}
