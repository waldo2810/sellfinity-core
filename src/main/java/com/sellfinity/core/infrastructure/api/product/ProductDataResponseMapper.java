package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.domain.entity.ProductData;
import com.sellfinity.core.infrastructure.api.category.CategoryResponseMapper;
import com.sellfinity.core.infrastructure.api.color.ColorResponseMapper;
import com.sellfinity.core.infrastructure.api.image.ImageResponseMapper;
import com.sellfinity.core.infrastructure.api.size.SizeResponseMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductResponseMapper.class, ImageResponseMapper.class,
    CategoryResponseMapper.class, SizeResponseMapper.class, ColorResponseMapper.class})
public interface ProductDataResponseMapper extends EntityToDto<ProductData, ProductDataResponse> {

}
