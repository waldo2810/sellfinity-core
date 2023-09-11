package com.sellfinity.core.infrastructure.api.image;

import com.sellfinity.core.domain.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ImageRequestMapper {

  @Mapping(target = "product.id", source = "productId")
  Image toEntity(ImageRequest imageRequest);
}
