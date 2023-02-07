package com.br.atos.APIUsers.exception.config;

import com.br.atos.APIUsers.exception.config.erros.DuplicateUserException;
import com.br.atos.APIUsers.exception.config.erros.UserExceptionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(UserExceptionNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestResponseError handlerError(UserExceptionNotFound e){
        return RestResponseError.userNotFoundException(e.getMessage());
    }

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public RestResponseError handlerError(DuplicateUserException e){
        return RestResponseError.userNotFoundException(e.getMessage());
    }
}
