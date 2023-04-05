package com.rafael.ProductApi.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private String description;

    private Double price;

    private boolean isActive;

    private Integer quantity;

    @ManyToOne(cascade= CascadeType.ALL)
    private Category category;

    private String image;
}
