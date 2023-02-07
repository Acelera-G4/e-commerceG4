package com.br.atos.APIUsers.exception.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponseError {

    private String error;

    public static RestResponseError userNotFoundException(String mensage){
        RestResponseError rest = new RestResponseError();
        rest.error = mensage;
        return rest;

    }
}
