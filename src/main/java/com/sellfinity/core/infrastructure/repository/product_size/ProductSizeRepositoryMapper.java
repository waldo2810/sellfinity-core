package com.sellfinity.core.infrastructure.repository.product_size;

import com.sellfinity.core.domain.entity.ProductSize;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductSizeRepositoryMapper extends EntityToDto<ProductSize, ProductSizeDto> {

}
