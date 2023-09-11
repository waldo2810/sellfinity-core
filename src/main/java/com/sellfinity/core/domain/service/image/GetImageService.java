package com.sellfinity.core.domain.service.image;

import com.sellfinity.core.domain.entity.Image;
import java.util.List;

public interface GetImageService {

  List<Image> findAllImagesByProduct(Long productId);

  Image findImageById(Long id);
}
