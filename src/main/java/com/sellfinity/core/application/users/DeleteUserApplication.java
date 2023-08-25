package com.sellfinity.core.application.users;

import com.sellfinity.core.domain.service.users.DeleteUserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteUserApplication {

  private final DeleteUserService deleteUserService;

  public void deleteUser(Long id) {
    deleteUserService.deleteUser(id);
  }
}
