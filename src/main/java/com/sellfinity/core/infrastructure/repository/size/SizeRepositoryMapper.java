package com.sellfinity.core.infrastructure.repository.size;

import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface SizeRepositoryMapper extends EntityToDto<Size, SizeDto> {

}
