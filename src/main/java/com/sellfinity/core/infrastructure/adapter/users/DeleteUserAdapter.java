package com.sellfinity.core.infrastructure.adapter.users;

import com.sellfinity.core.domain.service.users.DeleteUserService;
import com.sellfinity.core.infrastructure.repository.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserAdapter implements DeleteUserService {

  private final UserRepository userRepository;

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
