package com.sellfinity.core.infrastructure.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {

  @Modifying
  @Query("UPDATE UserDto user SET user.name = ?2, user.updatedAt = CURRENT_TIMESTAMP WHERE user.id = ?1")
  void updateUser(Long id, String name);
}
