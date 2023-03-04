package br.com.DrinksAndClubs.Order.exception.errors;

public class OrderExceptionNotFound extends RuntimeException {
    public OrderExceptionNotFound(String message){
        super(message);
    }
}
