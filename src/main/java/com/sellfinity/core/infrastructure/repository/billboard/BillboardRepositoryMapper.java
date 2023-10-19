package com.sellfinity.core.infrastructure.repository.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.infrastructure.repository.category.CategoryRepositoryMapper;
import com.sellfinity.core.infrastructure.repository.store.StoreRepositoryMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    CategoryRepositoryMapper.class,
    StoreRepositoryMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BillboardRepositoryMapper extends EntityToDto<Billboard, BillboardDto> {

}
