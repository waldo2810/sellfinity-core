package com.sellfinity.core.infrastructure.api.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.infrastructure.api.store.StoreResponseMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    StoreResponseMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryResponseMapper extends EntityToDto<Category, CategoryResponse> {

}
