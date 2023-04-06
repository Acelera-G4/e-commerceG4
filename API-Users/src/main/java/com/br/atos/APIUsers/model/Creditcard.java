package com.br.atos.APIUsers.model;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
public class Creditcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; //Tipo do cartão: Debito ou Credito

    private String number; //Numero do cartão

    private String name; //Nome do titular do cartão

    private Integer secretCode; //Código de segurança do cartão

    private Date validate; //Validade do cartão no formato MM/YYYY

    private String installment; //Parcelado ou a vista;

}
