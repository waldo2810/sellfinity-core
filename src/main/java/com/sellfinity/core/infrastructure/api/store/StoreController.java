package com.sellfinity.core.infrastructure.api.store;

import com.sellfinity.core.application.store.SaveStoreApplication;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
@AllArgsConstructor
public class StoreController {

  private final SaveStoreApplication saveStoreApplication;
  private final StoreRequestMapper storeRequestMapper;
  private final StoreResponseMapper storeResponseMapper;

  @PostMapping
  public ResponseEntity<StoreResponse> saveStore(@RequestBody StoreRequest storeRequest) {
    return ResponseEntity.ok(storeResponseMapper.toDto(
        saveStoreApplication.save(storeRequestMapper.toEntity(storeRequest))));
  }
}