package com.sellfinity.core.infrastructure.api.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.shared.exception.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryResponseMapper extends EntityToDto<Category, CategoryResponse> {

}
