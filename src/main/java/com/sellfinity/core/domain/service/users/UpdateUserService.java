package com.sellfinity.core.domain.service.users;

import com.sellfinity.core.domain.entity.Users;

public interface UpdateUserService {

  void updateUser(Long id, Users user);
}
