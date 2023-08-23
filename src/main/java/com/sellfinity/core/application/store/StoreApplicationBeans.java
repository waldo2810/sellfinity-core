package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.service.store.SaveStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreApplicationBeans {

  @Bean
  public SaveStoreApplication saveStoreApplication(
      SaveStoreService saveStoreService) {
    return new SaveStoreApplication(saveStoreService);
  }
}
