package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.domain.entity.ProductImage;
import com.sellfinity.core.infrastructure.api.image.ImageResponseMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductResponseMapper.class, ImageResponseMapper.class})
public interface ProductImageResponseMapper extends
    EntityToDto<ProductImage, ProductImageResponse> {

}
