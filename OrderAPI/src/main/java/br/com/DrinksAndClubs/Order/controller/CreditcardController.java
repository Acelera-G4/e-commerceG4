package br.com.DrinksAndClubs.Order.controller;

import br.com.DrinksAndClubs.Order.model.Creditcard;
import br.com.DrinksAndClubs.Order.services.CreditcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CreditcardController {

    private final CreditcardService ccService;

    @GetMapping
    public List<Creditcard> getAllCards(){
        return ccService.getAllCards();
    }

    @GetMapping("/{id}")
    public Creditcard findCcById(@PathVariable Long id){
        return ccService.findCcById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Creditcard createCC(@RequestBody Creditcard creditcard){
        return ccService.createCC(creditcard);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCC(@RequestBody Creditcard creditcard,@PathVariable Long id){
        return ccService.updateCC(creditcard, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCC(@PathVariable Long id){
        ccService.deleteCC(id);
    }

}
