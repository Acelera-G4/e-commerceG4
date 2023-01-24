package com.br.atos.APIUsers.exception.config.erros;

public class DuplicateUserException extends RuntimeException {

    public DuplicateUserException(String menssage) {
        super(menssage);
    }
}
