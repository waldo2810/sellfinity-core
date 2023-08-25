package com.sellfinity.core.infrastructure.repository.store;

import com.sellfinity.core.infrastructure.repository.users.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name = "store")
public class StoreDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserDto user;
  /*
  @OneToMany(mappedBy = "store")
  private List<CategoryDto> categories;
  */
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
