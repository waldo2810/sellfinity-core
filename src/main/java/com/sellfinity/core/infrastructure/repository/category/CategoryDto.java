package com.sellfinity.core.infrastructure.repository.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class CategoryDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long billboardId;
  @NotNull
  private String name;
  /*private CategoryProduct products;*/
  private String products;
  @NotNull
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
