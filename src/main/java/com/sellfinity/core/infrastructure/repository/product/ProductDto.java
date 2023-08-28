package com.sellfinity.core.infrastructure.repository.product;

import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import com.sellfinity.core.infrastructure.repository.store.StoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
  @ManyToMany
  List<CategoryDto> category;
  private String name;
  private Double price;
  private Boolean isFeatured;
  private Boolean isArchived;
  @NotNull
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;


}
