package com.sellfinity.core.infrastructure.repository.size;

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
@Table(name = "sizes")
public class SizeDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  private String name;
  @NotNull
  private String value;
  @NotNull
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private StoreDto store;
  @NotNull
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}