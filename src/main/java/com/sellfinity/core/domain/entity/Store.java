package com.sellfinity.core.domain.entity;


import lombok.Data;

import java.util.List;
@Data
public class Store {

    private Long id;

    private String name;
    private String userId;
    private List<Category> categories;

    /*@OneToMany(mappedBy = "store")
    private List<Product> products;

    @OneToMany(mappedBy = "store")
    private List<Size> sizes;

    @OneToMany(mappedBy = "store")
    private List<Color> colors;

    @OneToMany(mappedBy = "store")
    private List<Order> orders;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
     @OneToMany(mappedBy = "store")
    private List<Billboard> billboards;
    */

}
