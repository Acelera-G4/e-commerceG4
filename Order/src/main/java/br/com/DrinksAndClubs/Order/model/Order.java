package br.com.DrinksAndClubs.Order.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //ID do pedido

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number; //Numero do pedido

//    private List<Product> id_product = new ArrayList<>(); //ID dos produtos do cliente
//    private List<String> id_product = new ArrayList<>(); //ID dos produtos do cliente

    @Column(nullable = false)
    private String payment; //tipo de pagamento



//    @ManyToOne(optional = false)
//    @JoinColumn(name = "id_credicard_id", nullable = false)
//    private Creditcard ID_Credicard; //ID do cartão de crédito

    @NotNull
    private Boolean delivery; //Forma de entrega

//    @Id
//    private Long ID_Client; //Id do cliente
}
