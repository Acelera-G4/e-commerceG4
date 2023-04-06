package br.com.DrinksAndClubs.Order.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderProduct {
    @Id
    private Long Id;
    private String name;
    private int quantity;
    private double price;

    private Long idProduct;
}
