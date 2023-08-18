package com.sellfinity.core.infrastructure.api.category;

import com.sellfinity.core.domain.entity.Category;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRequestMapper extends EntityToDto<Category, CategoryRequest> {

}
