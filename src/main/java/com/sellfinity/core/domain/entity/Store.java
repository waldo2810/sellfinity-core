package com.sellfinity.core.domain.entity;


import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Store {

  private Long id;
  private String name;
  private String userId;
  private List<Category> categories;
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
