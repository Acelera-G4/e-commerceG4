package com.br.atos.APIUsers.exception.config.erros;

public class UserExceptionNotFound extends RuntimeException {

    public UserExceptionNotFound(String message){
        super(message);
    }
}
