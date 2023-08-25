package com.sellfinity.core.application.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.domain.service.users.UpdateUserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateUserApplication {

  private final UpdateUserService updateUserService;
  private final GetUserApplication getUserApplication;

  @Transactional
  public void updateUser(Long id, Users user) {
    getUserApplication.findUserById(id);
    updateUserService.updateUser(id,user);
  }
}
