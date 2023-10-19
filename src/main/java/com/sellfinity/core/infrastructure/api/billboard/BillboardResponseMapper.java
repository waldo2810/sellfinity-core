package com.sellfinity.core.infrastructure.api.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.infrastructure.api.category.CategoryResponseMapper;
import com.sellfinity.core.infrastructure.api.store.StoreResponseMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    CategoryResponseMapper.class,
    StoreResponseMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BillboardResponseMapper extends EntityToDto<Billboard, BillBoardResponse> {

}
