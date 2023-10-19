package com.sellfinity.core.application.image;

import com.sellfinity.core.domain.service.image.DeleteImageService;
import com.sellfinity.core.domain.service.image.GetImageService;
import com.sellfinity.core.domain.service.image.SaveImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageApplicationBeans {

  @Bean
  public GetImageApplication createGetImageApplication(GetImageService getImageService) {
    return new GetImageApplication(getImageService);
  }

  @Bean
  public SaveImageApplication createSaveImageApplication(SaveImageService saveImageService) {
    return new SaveImageApplication(saveImageService);
  }

  @Bean
  public DeleteImageApplication createDeleteImageApplication(
      DeleteImageService deleteImageService) {
    return new DeleteImageApplication(deleteImageService);
  }

  @Bean
  public UpdateImageApplication createUpdateImageApplication(
      DeleteImageApplication deleteImageApplication, SaveImageApplication saveImageApplication) {
    return new UpdateImageApplication(deleteImageApplication, saveImageApplication);
  }
}
