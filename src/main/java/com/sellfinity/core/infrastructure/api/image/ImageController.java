package com.sellfinity.core.infrastructure.api.image;

import com.sellfinity.core.application.image.GetImageApplication;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
@AllArgsConstructor
public class ImageController {

  private final GetImageApplication getImageApplication;
  private final ImageResponseMapper imageResponseMapper;

  @GetMapping
  public ResponseEntity<List<ImageResponse>> findAllImagesByProduct(
      @RequestParam("productId") Long productId) {
    return ResponseEntity.ok(
        imageResponseMapper.toDto(getImageApplication.findAllImagesByProduct(productId)));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<ImageResponse> findImageById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(imageResponseMapper.toDto(getImageApplication.findImageById(id)));
  }
}
