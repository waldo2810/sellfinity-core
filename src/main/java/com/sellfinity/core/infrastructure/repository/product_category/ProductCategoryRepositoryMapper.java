package com.sellfinity.core.infrastructure.repository.product_category;

import com.sellfinity.core.domain.entity.ProductCategory;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductCategoryRepositoryMapper extends
    EntityToDto<ProductCategory, ProductCategoryDto> {

}
