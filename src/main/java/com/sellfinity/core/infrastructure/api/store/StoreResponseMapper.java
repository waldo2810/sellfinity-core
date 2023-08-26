package com.sellfinity.core.infrastructure.api.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.infrastructure.api.users.UserResponseMapper;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {
    UserResponseMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StoreResponseMapper extends EntityToDto<Store, StoreResponse> {

}
