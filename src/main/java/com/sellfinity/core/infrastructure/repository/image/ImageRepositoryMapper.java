package com.sellfinity.core.infrastructure.repository.image;

import com.sellfinity.core.domain.entity.Image;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface ImageRepositoryMapper extends EntityToDto<Image, ImageDto> {

}
