package com.sellfinity.core.application.store;

import com.sellfinity.core.application.users.GetUserApplication;
import com.sellfinity.core.domain.service.store.DeleteStoreService;
import com.sellfinity.core.domain.service.store.GetStoreService;
import com.sellfinity.core.domain.service.store.SaveStoreService;
import com.sellfinity.core.domain.service.store.UpdateStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreApplicationBeans {

  @Bean
  public SaveStoreApplication saveStoreApplication(
      SaveStoreService saveStoreService, GetUserApplication getUserApplication) {
    return new SaveStoreApplication(saveStoreService, getUserApplication);
  }

  @Bean
  public GetStoreApplication getStoreApplication(
      GetStoreService getStoreService, GetUserApplication getUserApplication) {
    return new GetStoreApplication(getStoreService, getUserApplication);
  }

  @Bean
  public DeleteStoreApplication deleteStoreApplication(
      DeleteStoreService deleteStoreService) {
    return new DeleteStoreApplication(deleteStoreService);
  }

  @Bean
  public UpdateStoreApplication updateStoreApplication(
      UpdateStoreService updateStoreService, GetStoreApplication getStoreApplication) {
    return new UpdateStoreApplication(updateStoreService, getStoreApplication);
  }
}
