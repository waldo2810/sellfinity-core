package com.sellfinity.core.application.store;

import com.sellfinity.core.domain.service.store.UpdateStoreService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateStoreApplication {
    private final UpdateStoreService updateStoreService;
    @Transactional
    public void updateStore(Long id, String name){
        updateStoreService.updateStore(id,name);
    }

}
