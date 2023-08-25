package com.sellfinity.core.infrastructure.adapter.users;

import com.sellfinity.core.domain.entity.Users;
import com.sellfinity.core.domain.service.users.GetUserService;
import com.sellfinity.core.infrastructure.repository.users.UserRepository;
import com.sellfinity.core.infrastructure.repository.users.UserRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.user.UserNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserAdapter implements GetUserService {

  private final UserRepository userRepository;
  private final UserRepositoryMapper userRepositoryMapper;

  @Override
  public List<Users> findAllUsers() {
    return userRepositoryMapper.toEntity(userRepository.findAll());
  }

  @Override
  public Users findUserById(Long id) {
    return userRepositoryMapper.toEntity(
        userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(String.valueOf(id))));
  }
}
