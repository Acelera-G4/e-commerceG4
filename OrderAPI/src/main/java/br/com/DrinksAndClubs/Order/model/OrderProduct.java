package br.com.DrinksAndClubs.Order.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_orderProduct")
@Data
public class OrderProduct {
    @Id
    private Long Id;
    private String name;
    private int quantity;
    private double unit;
}
