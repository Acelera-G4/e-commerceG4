package br.com.DrinksAndClubs.Order.exception.errors;

public class CreditcardOrderExceptionNotFound extends RuntimeException {
    public CreditcardOrderExceptionNotFound(String message){
        super(message);
    }
}
