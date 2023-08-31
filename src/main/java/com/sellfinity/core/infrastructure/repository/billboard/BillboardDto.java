package com.sellfinity.core.infrastructure.repository.billboard;

import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import com.sellfinity.core.infrastructure.repository.store.StoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "billboard")
public class BillboardDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private StoreDto store;
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private CategoryDto category;
  private String label;
  private String imageUrl;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;
}