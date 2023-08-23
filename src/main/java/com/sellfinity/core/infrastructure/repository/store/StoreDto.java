package com.sellfinity.core.infrastructure.repository.store;

import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "store")
public class StoreDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String userId;
  @OneToMany(mappedBy = "store")
  private List<CategoryDto> categories;
  /*
  @OneToMany(mappedBy = "store")
  private List<Product> products;
  */
  /*
  @OneToMany(mappedBy = "store")
  private List<Size> sizes;
  */
  /*
  @OneToMany(mappedBy = "store")
  private List<Color> colors;
  */
  /*
  @OneToMany(mappedBy = "store")
  private List<Order> orders;
  */
  /*
   @OneToMany(mappedBy = "store")
  private List<Billboard> billboards;
  */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
