package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.application.product.SaveProductApplication;
import com.sellfinity.core.infrastructure.api.category.CategoryRequest;
import com.sellfinity.core.infrastructure.api.category.CategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
  private final SaveProductApplication saveProductApplication;
  private final ProductResponseMapper productResponseMapper;
  private final ProductRequestMapper productRequestMapper;
  @PostMapping
  public ResponseEntity<ProductResponse> saveProduct(
      @Valid @RequestBody ProductRequest productRequest) {
    return ResponseEntity.ok(
        productResponseMapper.toDto(
            saveProductApplication.saveProduct(productRequestMapper.toEntity(productRequest))));
  }
}
