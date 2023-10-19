package com.sellfinity.core.infrastructure.api.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import com.sellfinity.core.infrastructure.api.category.CategoryRequestMapper;
import com.sellfinity.core.infrastructure.api.store.StoreRequestMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {
    CategoryRequestMapper.class,
    StoreRequestMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BillboardRequestMapper extends EntityToDto<Billboard, BillboardRequest> {

  @Mapping(target = "store.id", source = "storeId")
  @Mapping(target = "category.id", source = "categoryId")
  Billboard toEntity(BillboardRequest billBoardRequest);
}
