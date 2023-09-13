package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.application.product.DeleteProductApplication;
import com.sellfinity.core.application.product.GetProductApplication;
import com.sellfinity.core.application.product.SaveProductApplication;
import com.sellfinity.core.application.product.UpdateProductApplication;
import com.sellfinity.core.infrastructure.api.image.ImageRequestMapper;
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
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

  private final SaveProductApplication saveProductApplication;
  private final GetProductApplication getProductApplication;
  private final DeleteProductApplication deleteProductApplication;
  private final UpdateProductApplication updateProductApplication;
  private final ProductResponseMapper productResponseMapper;
  private final ProductDataResponseMapper productDataResponseMapper;
  private final ProductRequestMapper productRequestMapper;
  private final ImageRequestMapper imageRequestMapper;

  @PostMapping
  public ResponseEntity<ProductResponse> saveProduct(
      @Valid @RequestBody ProductRequest productRequest) {
    return ResponseEntity.ok(productResponseMapper.toDto(
        saveProductApplication.saveProduct(
            productRequestMapper.toEntity(productRequest),
            productRequest.getCategoryIds(),
            productRequest.getSizeIds(),
            productRequest.getColorIds(),
            imageRequestMapper.toEntity(productRequest.getImages()))));
  }

  @GetMapping
  public ResponseEntity<List<ProductDataResponse>> findAllProducts(
      @Nullable @RequestParam("storeId") Long storeId) {
    return ResponseEntity.ok(
        productDataResponseMapper.toDto(getProductApplication.findAllProducts(storeId)));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<ProductDataResponse> findProductById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        productDataResponseMapper.toDto(getProductApplication.findProductById(id)));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteProduct(@PathVariable("id") Long id) {
    deleteProductApplication.deleteProduct(id);
  }

  @PutMapping("/update/{id}")
  public void updateProduct(
      @Valid @RequestBody ProductRequest productRequest, @PathVariable("id") Long id) {
    updateProductApplication.updateProduct(id, productRequestMapper.toEntity(productRequest),
        productRequest.getCategoryIds(), productRequest.getSizeIds(), productRequest.getColorIds(),
        imageRequestMapper.toEntity(productRequest.getImages()));
  }
}
