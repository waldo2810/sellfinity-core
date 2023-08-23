package com.sellfinity.core.infrastructure.repository.store;

import com.sellfinity.core.domain.entity.Store;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface StoreRepositoryMapper {

  Store toEntity(StoreDto dto);

  List<Store> toEntity(List<StoreDto> dtos);

  StoreDto toDto(Store entity);
}
