package com.sellfinity.core.application.size;

import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.service.size.DeleteSizeService;
import com.sellfinity.core.domain.service.size.GetSizeService;
import com.sellfinity.core.domain.service.size.SaveSizeService;
import com.sellfinity.core.domain.service.size.UpdateSizeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SizeApplicationBeans {

  @Bean
  public GetSizeApplication createGetSizeApplication(
      GetSizeService getSizeService, GetStoreApplication getStoreApplication) {
    return new GetSizeApplication(getSizeService, getStoreApplication);
  }

  @Bean
  public SaveSizeApplication createSaveSizeApplication(
      SaveSizeService saveSizeService) {
    return new SaveSizeApplication(saveSizeService);
  }

  @Bean
  public DeleteSizeApplication createDeleteSizeApplication(
      DeleteSizeService deleteSizeService) {
    return new DeleteSizeApplication(deleteSizeService);
  }

  @Bean
  public UpdateSizeApplication createUpdateSizeApplication(
      UpdateSizeService updateSizeService, GetSizeApplication getSizeApplication) {
    return new UpdateSizeApplication(updateSizeService, getSizeApplication);
  }
}
