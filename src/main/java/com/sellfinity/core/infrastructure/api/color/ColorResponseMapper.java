package com.sellfinity.core.infrastructure.api.color;

import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ColorResponseMapper extends EntityToDto<Color, ColorResponse> {

}
