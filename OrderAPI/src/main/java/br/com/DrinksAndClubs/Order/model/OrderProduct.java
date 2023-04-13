package br.com.DrinksAndClubs.Order.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order2")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private int quantity;
    private double price;

    private Long idProduct;
}
