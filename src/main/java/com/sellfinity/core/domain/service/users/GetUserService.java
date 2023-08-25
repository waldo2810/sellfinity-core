package com.sellfinity.core.domain.service.users;

import com.sellfinity.core.domain.entity.Users;
import java.util.List;

public interface GetUserService {

  List<Users> findAllUsers();

  Users findUserById(Long id);
}
