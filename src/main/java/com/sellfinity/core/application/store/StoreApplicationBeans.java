package com.sellfinity.core.application.store;

import com.sellfinity.core.application.category.DeleteCategoryApplication;
import com.sellfinity.core.application.category.GetCategoryApplication;
import com.sellfinity.core.application.category.SaveCategoryApplication;
import com.sellfinity.core.application.category.UpdateCategoryApplication;
import com.sellfinity.core.domain.service.category.DeleteCategoryService;
import com.sellfinity.core.domain.service.category.GetCategoryService;
import com.sellfinity.core.domain.service.category.SaveCategoryService;
import com.sellfinity.core.domain.service.category.UpdateCategoryService;
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
