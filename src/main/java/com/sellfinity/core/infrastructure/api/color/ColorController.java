package com.sellfinity.core.infrastructure.api.color;

import com.sellfinity.core.application.color.DeleteColorApplication;
import com.sellfinity.core.application.color.GetColorApplication;
import com.sellfinity.core.application.color.SaveColorApplication;
import com.sellfinity.core.application.color.UpdateColorApplication;
import com.sellfinity.core.domain.entity.Color;
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
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorController {

  private final GetColorApplication getColorApplication;
  private final SaveColorApplication saveColorApplication;
  private final DeleteColorApplication deleteColorApplication;
  private final UpdateColorApplication updateColorApplication;
  private final ColorResponseMapper colorResponseMapper;
  private final ColorRequestMapper colorRequestMapper;

  @GetMapping
  public ResponseEntity<List<ColorResponse>> findAllColors(
      @Nullable @RequestParam("storeId") Long storeId) {
    return ResponseEntity.ok(
        colorResponseMapper.toDto(getColorApplication.findAllColors(storeId)));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<ColorResponse> findColorById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        colorResponseMapper.toDto(getColorApplication.findColorById(id)));
  }

  @PostMapping
  public ResponseEntity<ColorResponse> saveColor(
      @Valid @RequestBody ColorRequest Color) {
    return ResponseEntity.ok(
        colorResponseMapper.toDto(
            saveColorApplication.saveColor(colorRequestMapper.toEntity(Color))));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteColor(@PathVariable("id") Long id, @RequestParam("storeId") Long storeId) {
    deleteColorApplication.deleteColor(id, storeId);
  }

  @PutMapping("/update/{id}")
  public void updateColor(@PathVariable("id") Long id,
      @RequestBody ColorRequest ColorRequest) {
    Color Color = colorRequestMapper.toEntity(ColorRequest);
    updateColorApplication.updateColor(id, Color);
  }
}
