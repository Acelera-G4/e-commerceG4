package com.rafael.ProductApi.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private String description;

    private Double price;

    private boolean isActive;

    private Integer quantity;

    @ManyToOne
    private Category category;

    private String image;
}
