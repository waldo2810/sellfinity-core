package com.sellfinity.core.infrastructure.repository.color;

import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ColorRepositoryMapper extends EntityToDto<Color, ColorDto> {

}
