package com.sellfinity.core.infrastructure.repository.image;

import com.sellfinity.core.infrastructure.repository.product.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "images")
public class ImageDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductDto product;
  @NotNull
  private String url;
  @NotNull
  private LocalDateTime createdAt;
}
