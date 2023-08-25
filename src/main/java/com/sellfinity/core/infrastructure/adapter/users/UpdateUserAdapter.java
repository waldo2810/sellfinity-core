package com.sellfinity.core.infrastructure.adapter.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.domain.service.users.UpdateUserService;
import com.sellfinity.core.infrastructure.repository.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserAdapter implements UpdateUserService {

  private final UserRepository userRepository;

  @Override
  public void updateUser(Long id, Users user) {
    String name = user.getName();
    userRepository.updateUser(id, name);
  }
}
