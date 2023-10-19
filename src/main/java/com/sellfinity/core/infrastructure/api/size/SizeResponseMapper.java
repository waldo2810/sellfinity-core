package com.sellfinity.core.infrastructure.api.size;

import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface SizeResponseMapper extends EntityToDto<Size, SizeResponse> {

}
