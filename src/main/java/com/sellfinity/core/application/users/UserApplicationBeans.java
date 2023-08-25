package com.sellfinity.core.application.users;

import com.sellfinity.core.domain.service.users.DeleteUserService;
import com.sellfinity.core.domain.service.users.GetUserService;
import com.sellfinity.core.domain.service.users.SaveUserService;
import com.sellfinity.core.domain.service.users.UpdateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserApplicationBeans {

  @Bean
  public SaveUserApplication saveUserApplication(SaveUserService saveUserService) {
    return new SaveUserApplication(saveUserService);
  }

  @Bean
  public GetUserApplication getUserApplication(GetUserService getUserService) {
    return new GetUserApplication(getUserService);
  }

  @Bean
  public UpdateUserApplication updateUserApplication(UpdateUserService updateUserService,
      GetUserApplication getUserApplication) {
    return new UpdateUserApplication(updateUserService, getUserApplication);
  }

  @Bean
  public DeleteUserApplication deleteUserApplication(DeleteUserService deleteUserService) {
    return new DeleteUserApplication(deleteUserService);
  }
}
