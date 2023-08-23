package com.sellfinity.core.infrastructure.repository.category;

import com.sellfinity.core.infrastructure.repository.store.StoreDto;
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
@Table(name = "categories")
public class CategoryDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long billboardId;
  @NotNull
  private String name;
  @ManyToOne
  @JoinColumn(name = "store_id")
  private StoreDto store;
  private String products;
  @NotNull
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
