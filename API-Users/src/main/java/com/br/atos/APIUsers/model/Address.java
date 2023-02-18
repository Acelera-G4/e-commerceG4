package com.br.atos.APIUsers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String cep;

    public String street;
    public String number;
    public String complement;
    //localidade

    public String city;
    public String uf;

    @ManyToOne
    private User user;
}
