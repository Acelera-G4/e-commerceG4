package br.com.DrinksAndClubs.Order.controller;

import br.com.DrinksAndClubs.Order.model.Creditcard;
import br.com.DrinksAndClubs.Order.services.CreditcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CreditcardController {

    private final CreditcardService creditcardService;

    @PostMapping
    public Creditcard create(@RequestBody Creditcard creditcard){
        return creditcardService.create(creditcard);
    }

    @GetMapping("/{id}")
    public Creditcard getIDCard(long id){
        return creditcardService.getIDCard(id);
    }

    @GetMapping("/{name}")
    public List<Creditcard> getAllCards(String name){
        return creditcardService.getAllCards(name);
    }

    @PutMapping
    public Creditcard update(Creditcard creditcard){
        return creditcardService.update(creditcard);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        creditcardService.delete(id);
    }
}
