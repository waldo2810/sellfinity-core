package com.sellfinity.core.infrastructure.api.users;

import com.sellfinity.core.application.users.DeleteUserApplication;
import com.sellfinity.core.application.users.GetUserApplication;
import com.sellfinity.core.application.users.SaveUserApplication;
import com.sellfinity.core.application.users.UpdateUserApplication;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

  private final GetUserApplication getUserApplication;
  private final SaveUserApplication saveUserApplication;
  private final DeleteUserApplication deleteUserApplication;
  private final UpdateUserApplication updateUserApplication;
  private final UserResponseMapper userResponseMapper;
  private final UserRequestMapper userRequestMapper;

  @GetMapping
  public ResponseEntity<List<UserResponse>> findAllUsers() {
    return ResponseEntity.ok(userResponseMapper.toDto(getUserApplication.findAllUsers()));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<UserResponse> findUserById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(userResponseMapper.toDto(getUserApplication.findUserById(id)));
  }

  @PostMapping
  public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserRequest user) {
    return ResponseEntity.ok(
        userResponseMapper.toDto(saveUserApplication.saveUser(userRequestMapper.toEntity(user))));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    deleteUserApplication.deleteUser(id);
  }

  @PutMapping("/update/{id}")
  public void updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserRequest userRequest) {
    updateUserApplication.updateUser(id, userRequestMapper.toEntity(userRequest));
  }
}