package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.domain.entity.Product;
import com.sellfinity.core.infrastructure.api.category.CategoryResponseMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    CategoryResponseMapper.class,
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductResponseMapper extends EntityToDto<Product, ProductResponse> {

}
