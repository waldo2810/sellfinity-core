package com.sellfinity.core.infrastructure.repository.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.infrastructure.repository.store.StoreRepositoryMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    StoreRepositoryMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryRepositoryMapper extends EntityToDto<Category, CategoryDto> {

}
