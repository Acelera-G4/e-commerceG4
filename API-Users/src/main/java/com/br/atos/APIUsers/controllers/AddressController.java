package com.br.atos.APIUsers.controllers;

import com.br.atos.APIUsers.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cep")
public class AddressController {

    @GetMapping("/{cep}")
    public ResponseEntity<Address> getCep(@PathVariable String cep){
        Address address = searchAddress(cep);
        return ResponseEntity.ok(address);
    }

    public Address searchAddress(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return new RestTemplate().getForObject(url, Address.class);
    }
}
