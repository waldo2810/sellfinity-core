package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.entity.Store;
import com.sellfinity.core.domain.service.store.SaveStoreService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveStoreApplication {
    private final SaveStoreService saveStoreService;
    public void save(Store store){
        saveStoreService.save(store);
    }
}
