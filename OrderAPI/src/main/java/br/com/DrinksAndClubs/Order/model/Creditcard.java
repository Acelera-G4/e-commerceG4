package br.com.DrinksAndClubs.Order.model;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tb_creditcard")
@Data
public class Creditcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditcardID;

    private String Type; //Tipo do cartão: Debito ou Credito

    private String Number; //Numero do cartão

    private String Name; //Nome do titular do cartão

    private Integer SecretCode; //Código de segurança do cartão

    private Date Validate; //Validade do cartão no formato MM/YYYY

    private String Installment; //Parcelado ou a vista;

}
