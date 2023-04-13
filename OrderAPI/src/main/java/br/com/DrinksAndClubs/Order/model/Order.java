package br.com.DrinksAndClubs.Order.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "order1")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID; //ID do pedido

    private Long numberOrder; //Numero do pedido

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderProduct> listProducts = new ArrayList<>();
    private String payment; //tipo de pagamento

    private boolean delivery; //Forma de entrega se true = entrega; else takeaway

    private boolean finished;
    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    private Long clientID; //Id do cliente(user)

}
