package br.com.DrinksAndClubs.Order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

//@Table(name = "tb_credit-card")
@Data
@Entity
@Getter
@Setter
public class Creditcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String Type; //Tipo do cartão: Debito ou Credito

    private String Number; //Numero do cartão

    private String Name; //Nome do titular do cartão

    private int SecretCode; //Código de segurança do cartão

    private Date Validate; //Validade do cartão no formato MM/YYYY

    private String Installment; //Parcelado ou a vista;

}
