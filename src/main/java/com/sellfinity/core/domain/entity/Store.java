package com.sellfinity.core.domain.entity;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Store {

  private Long id;
  private String name;
  private String userId;
  /*private List<Category> categories;*/
  /*private List<Product> products;*/
  /*private List<Size> sizes;*/
  /*private List<Color> colors; */
  /* private List<Order> orders;  */
  /*private List<Billboard> billboards; */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
