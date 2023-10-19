package com.sellfinity.core.infrastructure.repository.product_color;

import com.sellfinity.core.domain.entity.ProductColor;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductColorRepositoryMapper extends EntityToDto<ProductColor, ProductColorDto> {

}
