package com.sellfinity.core.infrastructure.api.image;

import com.sellfinity.core.domain.entity.Image;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ImageResponseMapper {

  @Mapping(target = "productId", source = "product.id")
  ImageResponse toDto(Image image);

  List<ImageResponse> toDto(List<Image> images);
}
