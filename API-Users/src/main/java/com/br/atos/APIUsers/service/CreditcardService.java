package com.br.atos.APIUsers.service;


import com.br.atos.APIUsers.exception.config.erros.CreditcardOrderExceptionNotFound;
import com.br.atos.APIUsers.model.Creditcard;
import com.br.atos.APIUsers.repository.CreditcardRepository;
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