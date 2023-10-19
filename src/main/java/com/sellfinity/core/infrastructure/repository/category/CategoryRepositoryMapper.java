package com.sellfinity.core.infrastructure.repository.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRepositoryMapper extends EntityToDto<Category, CategoryDto> {

}
