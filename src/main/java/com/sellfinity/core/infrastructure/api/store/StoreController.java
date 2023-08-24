package com.sellfinity.core.infrastructure.api.store;

import com.sellfinity.core.application.store.DeleteStoreApplication;
import com.sellfinity.core.application.store.GetStoreApplication;
import com.sellfinity.core.application.store.SaveStoreApplication;
import com.sellfinity.core.application.store.UpdateStoreApplication;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
@AllArgsConstructor
public class StoreController {

  private final SaveStoreApplication saveStoreApplication;
  private final UpdateStoreApplication updateStoreApplication;
  private final GetStoreApplication getStoreApplication;
  private final DeleteStoreApplication deleteStoreApplication;
  private final StoreRequestMapper storeRequestMapper;
  private final StoreResponseMapper storeResponseMapper;

  @PostMapping
  public ResponseEntity<StoreResponse> saveStore(@RequestBody StoreRequest storeRequest) {
    return ResponseEntity.ok(storeResponseMapper.toDto(
        saveStoreApplication.saveStore(storeRequestMapper.toEntity(storeRequest))));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<StoreResponse> findStoreById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        storeResponseMapper.toDto(getStoreApplication.findStoreById(id)));
  }

  @GetMapping
  public ResponseEntity<List<StoreResponse>> findAllStores() {
    return ResponseEntity.ok(
        storeResponseMapper.toDto(getStoreApplication.findAllStores()));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteStore(@PathVariable("id") Long id) {
    deleteStoreApplication.deleteStore(id);

  }

  @PutMapping("/update/{id}")
  public void updateCategory(@PathVariable("id") Long id,
      @RequestParam("name") String name) {
    updateStoreApplication.updateStore(id, name);
  }
}
