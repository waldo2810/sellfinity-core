package com.sellfinity.core.application.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.domain.service.users.GetUserService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetUserApplication {

  private final GetUserService getUserService;

  public List<Users> findAllUsers() {
    return getUserService.findAllUsers();
  }

  public Users findUserById(Long id) {
    return getUserService.findUserById(id);
  }
}
