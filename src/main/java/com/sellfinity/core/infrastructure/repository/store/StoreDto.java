package com.sellfinity.core.infrastructure.repository.store;

import com.sellfinity.core.infrastructure.repository.category.CategoryDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
