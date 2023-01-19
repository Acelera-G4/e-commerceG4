package com.br.atos.APIUsers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@Getter
@Setter
public class Address {

    public String cep;
    @JsonProperty(value = "logradouro")
    public String rua;
    public String complemento;
    public String bairro;
    //localidade
    @JsonProperty(value = "localidade")
    public String cidade;
    public String uf;
}
