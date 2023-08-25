package com.sellfinity.core.infrastructure.repository.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserRepositoryMapper extends EntityToDto<Users, UserDto> {

}
