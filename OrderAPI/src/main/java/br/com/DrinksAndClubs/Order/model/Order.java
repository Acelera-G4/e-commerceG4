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

    private boolean delivery; //Forma de entrega se true = entrega; else takeaway

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    private Long clientID; //Id do cliente(user)

    @ManyToOne
    private Creditcard credicard; //Dados do cartão de crédito

}
