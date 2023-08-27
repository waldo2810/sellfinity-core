package com.sellfinity.core.infrastructure.repository.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRepositoryMapper extends EntityToDto<Product, ProductDto> {

}
