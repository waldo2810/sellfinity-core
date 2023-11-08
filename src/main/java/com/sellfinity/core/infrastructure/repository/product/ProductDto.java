package com.sellfinity.core.infrastructure.repository.product;

import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryDto;
import com.sellfinity.core.infrastructure.repository.product_color.ProductColorDto;
import com.sellfinity.core.infrastructure.repository.product_size.ProductSizeDto;
import com.sellfinity.core.infrastructure.repository.store.StoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private StoreDto store;
  private String name;
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
  @NotNull
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  @OneToMany(mappedBy = "product")
  private List<ProductSizeDto> productSizes;
  @OneToMany(mappedBy = "product")
  private List<ProductColorDto> productColors;
  @OneToMany(mappedBy = "product")
  private List<ProductCategoryDto> productCategories;
}