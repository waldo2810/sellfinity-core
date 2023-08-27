package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductResponseMapper extends EntityToDto<Product, ProductResponse> {

}
