package br.com.DrinksAndClubs.Order.services;

import br.com.DrinksAndClubs.Order.exception.errors.CreditcardOrderExceptionNotFound;
import br.com.DrinksAndClubs.Order.model.Creditcard;
import br.com.DrinksAndClubs.Order.repository.CreditcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditcardService {

    private final CreditcardRepository ccRepository;

    public List<Creditcard> getAllCards() {
        return ccRepository.findAll();
    }

    public Creditcard findCcById(Long id) {
        return ccRepository.findById(id).orElseThrow(() -> new CreditcardOrderExceptionNotFound("ID do Cartão não encontrado!"));
    }

    public Creditcard createCC(Creditcard creditcard) {
        return ccRepository.save(creditcard);
    }

    public ResponseEntity updateCC(Creditcard creditcard, Long id) {
        return ccRepository.findById(id).map(
                newCC -> {
                    newCC.setType(creditcard.getType());
                    newCC.setNumber(creditcard.getNumber());
                    newCC.setName(creditcard.getName());
                    newCC.setSecretCode(creditcard.getSecretCode());
                    newCC.setValidate(creditcard.getValidate());
                    newCC.setInstallment(creditcard.getInstallment());
                    Creditcard updatedCC = ccRepository.save(newCC);
                    return ResponseEntity.ok().body(updatedCC);
                }).orElseThrow(() -> new CreditcardOrderExceptionNotFound("ID não encontrado!"));
    }

    public void deleteCC(Long id) {
        ccRepository.deleteById(id);
    }
}