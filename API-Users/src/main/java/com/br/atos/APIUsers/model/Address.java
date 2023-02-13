package com.br.atos.APIUsers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
public class Address {

    public String cep;
    @JsonProperty(value = "logradouro")
    public String rua;
    public String bairro;
    public String numero;
    public String complemento;
    //localidade
    @JsonProperty(value = "localidade")
    public String cidade;
    public String uf;
}
