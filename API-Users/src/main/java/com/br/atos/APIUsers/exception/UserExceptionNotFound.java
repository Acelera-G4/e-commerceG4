package com.br.atos.APIUsers.exception;

public class UserExceptionNotFound extends RuntimeException {

    public UserExceptionNotFound(String message){
        super(message);
    }
}
