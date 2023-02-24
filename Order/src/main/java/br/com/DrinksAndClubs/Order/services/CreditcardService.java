package br.com.DrinksAndClubs.Order.services;

import br.com.DrinksAndClubs.Order.exception.errors.OrderExceptionNotFound;
import br.com.DrinksAndClubs.Order.model.Creditcard;
import br.com.DrinksAndClubs.Order.repository.CreditcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditcardService {

    private final CreditcardRepository creditcardRepository;

    public Creditcard create(Creditcard creditcard) {
        return creditcardRepository.save(creditcard);
    }

    public Creditcard getIDCard(long id) {
        return creditcardRepository.findById(id)
                .orElseThrow(() -> new OrderExceptionNotFound("Cartão de Crédito não encontrado"));
    }

    public List<Creditcard> getAllCards(String name) {
        return creditcardRepository.findAllByName(name);
    }

}

