package com.sellfinity.core.infrastructure.repository.product_category;

import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import com.sellfinity.core.infrastructure.repository.product.ProductDto;
import com.sellfinity.core.infrastructure.repository.store.StoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_category")
public class ProductCategoryDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductDto product;
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private CategoryDto category;
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private StoreDto store;
}