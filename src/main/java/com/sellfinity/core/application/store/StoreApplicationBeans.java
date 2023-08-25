package com.sellfinity.core.application.store;

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
      SaveStoreService saveStoreService) {
    return new SaveStoreApplication(saveStoreService);
  }

  @Bean
  public GetStoreApplication getStoreApplication(
      GetStoreService getStoreService) {
    return new GetStoreApplication(getStoreService);
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
