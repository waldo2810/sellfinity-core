package com.sellfinity.core.infrastructure.repository.product_size;

import com.sellfinity.core.infrastructure.repository.product.ProductDto;
import com.sellfinity.core.infrastructure.repository.size.SizeDto;
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
@Table(name = "product_size")
public class ProductSizeDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductDto product;
  @ManyToOne
  @JoinColumn(name = "size_id", referencedColumnName = "id")
  private SizeDto size;
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private StoreDto store;
}