package com.sellfinity.core.infrastructure.api.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserRequestMapper extends EntityToDto<Users, UserRequest> {

}