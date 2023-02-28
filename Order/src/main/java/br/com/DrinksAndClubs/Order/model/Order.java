package br.com.DrinksAndClubs.Order.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:Order/src/main/java/br/com/DrinksAndClubs/Order/model/order.java
@Table(name = "tb_order")
=======
//@Table(name = "tb_order")
>>>>>>> main:Order/src/main/java/br/com/DrinksAndClubs/Order/model/Order.java
@Data
@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID; //ID do pedido

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Number; //Numero do pedido

<<<<<<< HEAD:Order/src/main/java/br/com/DrinksAndClubs/Order/model/order.java
    private List<Product> id_product = new ArrayList<>(); //ID dos produtos do cliente
=======
    private List<String> id_product = new ArrayList<>(); //ID dos produtos do cliente
>>>>>>> main:Order/src/main/java/br/com/DrinksAndClubs/Order/model/Order.java

    @Column(nullable = false)
    private String Payment; //tipo de pagamento

<<<<<<< HEAD:Order/src/main/java/br/com/DrinksAndClubs/Order/model/order.java
    @Id
=======
>>>>>>> main:Order/src/main/java/br/com/DrinksAndClubs/Order/model/Order.java
    private Creditcard ID_Credicard; //ID do cartão de crédito

    @NotNull
    private Boolean Delivery; //Forma de entrega

    @Id
    private Long ID_Client; //Id do cliente
}
