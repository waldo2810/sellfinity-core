package com.sellfinity.core.infrastructure.repository.store;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StoreRepositoryMapper {

  Store toEntity(StoreDto dto);

  List<Store> toEntity(List<StoreDto> dtos);

  StoreDto toDto(Store entity);
}
