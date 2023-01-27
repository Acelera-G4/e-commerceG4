package com.rafael.ProductApi.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Product {

    @Id
    private Integer productId;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    @ManyToOne
    private Category category;
}
