package br.com.DrinksAndClubs.Order.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

import java.util.ArrayList;

@Table(name = "tb_order")
@Data
@Entity
@Getter
@Setter
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID; //ID do pedido

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Number; //Numero do pedido

    @ManyToMany
    private List<Product> id_product = new ArrayList<>(); //ID dos produtos do cliente

    @Column(nullable = false)
    private String Payment; //tipo de pagamento

    @OneToMany
    @Id
    private Long ID_Credicard; //ID do cartão de crédito

    @NotNull
    private Boolean Delivery; //Forma de entrega

    @OneToMany
    @Id
    private Long ID_Client; //Id do cliente
}
