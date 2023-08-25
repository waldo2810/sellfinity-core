package com.sellfinity.core.infrastructure.adapter.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.domain.service.users.SaveUserService;
import com.sellfinity.core.infrastructure.repository.users.UserRepository;
import com.sellfinity.core.infrastructure.repository.users.UserRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveUserAdapter implements SaveUserService {

  private final UserRepository userRepository;
  private final UserRepositoryMapper userRepositoryMapper;

  @Override
  public Users saveUser(Users user) {
    return userRepositoryMapper.toEntity(
        userRepository.save(userRepositoryMapper.toDto(user)));
  }
}