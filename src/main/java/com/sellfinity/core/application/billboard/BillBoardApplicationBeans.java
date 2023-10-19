package com.sellfinity.core.application.billboard;

import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.domain.service.billboard.DeleteBillBoardService;
import com.sellfinity.core.domain.service.billboard.GetBillBoardService;
import com.sellfinity.core.domain.service.billboard.SaveBillboardService;
import com.sellfinity.core.domain.service.billboard.UpdateBillBoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillBoardApplicationBeans {

  @Bean
  public SaveBillboardApplication saveBillBoardApplication(
      SaveBillboardService saveBillBoardService,
      GetCategoryApplication getCategoryApplication) {
    return new SaveBillboardApplication(saveBillBoardService, getCategoryApplication);
  }

  @Bean
  public GetBillboardApplication getBillboardApplication(
      GetBillBoardService getBillBoardService, GetStoreApplication getStoreApplication) {
    return new GetBillboardApplication(getBillBoardService, getStoreApplication);
  }

  @Bean
  public DeleteBillboardApplication deleteBillboardApplication(
      DeleteBillBoardService deleteBillBoardService) {
    return new DeleteBillboardApplication(deleteBillBoardService);
  }

  @Bean
  public UpdateBillboardApplication updateBillboardApplication(
      UpdateBillBoardService updateBillBoardService,
      GetBillboardApplication getBillboardApplication,
      GetCategoryApplication getCategoryApplication,
      GetStoreApplication getStoreApplication) {
    return new UpdateBillboardApplication(updateBillBoardService, getBillboardApplication,
        getStoreApplication, getCategoryApplication);
  }
}
