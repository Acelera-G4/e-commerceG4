package br.com.DrinksAndClubs.Order.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID; //ID do pedido

    private Long number; //Numero do pedido

    @ManyToMany
    private List<OrderProduct> orderProduct = new ArrayList<>();
    private String payment; //tipo de pagamento

    private int delivery; //Forma de entrega

    private Long clientID; //Id do cliente

    @ManyToOne
    private Creditcard credicard; //Dados do cartão de crédito
}
