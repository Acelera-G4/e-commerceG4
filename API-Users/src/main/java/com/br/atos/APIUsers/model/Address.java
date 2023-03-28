package com.br.atos.APIUsers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String cep;

    @JsonProperty(value = "logradouro")
    public String street;
    @JsonProperty(value = "bairro")
    public String number;
    @JsonProperty(value = "complemento")
    public String complement;
    //localidade

    @JsonProperty(value = "localidade")
    public String city;
    public String uf;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private User user;
}
