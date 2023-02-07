package com.rafael.ProductApi.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {

    @Id
    private Integer categoryId;

    private String name;

    private String description;


}
