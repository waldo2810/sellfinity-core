package com.sellfinity.core.infrastructure.api.product;

import com.sellfinity.core.application.product.DeleteProductApplication;
import com.sellfinity.core.application.product.GetProductApplication;
import com.sellfinity.core.application.product.SaveProductApplication;
import com.sellfinity.core.application.product.UpdateProductApplication;
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
  private final ProductRequestMapper productRequestMapper;

  @PostMapping
  public ResponseEntity<ProductResponse> saveProduct(
      @Valid @RequestBody ProductRequest productRequest) {
    List<Long> categoryIds = productRequest.getCategoryIds();
    return ResponseEntity.ok(productResponseMapper.toDto(
        saveProductApplication.saveProduct(productRequestMapper.toEntity(productRequest),
            categoryIds)));
  }

  @GetMapping
  public ResponseEntity<List<ProductResponse>> findAllCategories() {
    return ResponseEntity.ok(
        productResponseMapper.toDto(getProductApplication.findAllStores()));
  }

  @GetMapping("/search/{id}")
  public ResponseEntity<ProductResponse> findCategoryById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        productResponseMapper.toDto(getProductApplication.findProductById(id)));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteProduct(@PathVariable("id") Long idProduct) {
    deleteProductApplication.deleteProduct(idProduct);
  }

  @PutMapping("/update")
  public void updateProduct(@RequestParam("idProduct") Long idProduct,
      @RequestParam("idStore") Long idStore,
      @Valid @RequestBody ProductRequest productRequest) {
    updateProductApplication.updateProduct(idProduct, idStore,
        productRequestMapper.toEntity(productRequest));
  }
}
