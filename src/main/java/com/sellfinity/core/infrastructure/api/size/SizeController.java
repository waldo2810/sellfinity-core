package com.sellfinity.core.infrastructure.api.size;

import com.sellfinity.core.application.size.DeleteSizeApplication;
import com.sellfinity.core.application.size.GetSizeApplication;
import com.sellfinity.core.application.size.SaveSizeApplication;
import com.sellfinity.core.application.size.UpdateSizeApplication;
import com.sellfinity.core.domain.entity.Size;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
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
@RequestMapping("/api/sizes")
@AllArgsConstructor
public class SizeController {

  private final GetSizeApplication getSizeApplication;
  private final SaveSizeApplication saveSizeApplication;
  private final DeleteSizeApplication deleteSizeApplication;
  private final UpdateSizeApplication updateSizeApplication;
  private final SizeResponseMapper sizeResponseMapper;
  private final SizeRequestMapper sizeRequestMapper;

  @GetMapping
  public ResponseEntity<List<SizeResponse>> findAllSizes(
      @Nullable @RequestParam("storeId") Long storeId) {
    return ResponseEntity.ok(
        sizeResponseMapper.toDto(getSizeApplication.findAllSizes(storeId)));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<SizeResponse> findColorById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        sizeResponseMapper.toDto(getSizeApplication.findSizeById(id)));
  }

  @PostMapping
  public ResponseEntity<SizeResponse> saveColor(
      @Valid @RequestBody SizeRequest Color) {
    return ResponseEntity.ok(
        sizeResponseMapper.toDto(
            saveSizeApplication.saveSize(sizeRequestMapper.toEntity(Color))));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteColor(@PathVariable("id") Long id, @RequestParam("storeId") Long storeId) {
    deleteSizeApplication.deleteSize(id, storeId);
  }

  @PutMapping("/update/{id}")
  public void updateColor(@PathVariable("id") Long id,
      @RequestBody SizeRequest ColorRequest) {
    Size size = sizeRequestMapper.toEntity(ColorRequest);
    updateSizeApplication.updateSize(id, size);
  }
}
