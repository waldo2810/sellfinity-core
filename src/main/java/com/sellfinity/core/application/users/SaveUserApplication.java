package com.sellfinity.core.application.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.domain.service.users.SaveUserService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveUserApplication {

  private final SaveUserService saveUserService;

  public Users saveUser(Users user) {
    user.setCreatedAt(LocalDateTime.now());
    return saveUserService.saveUser(user);
  }
}
