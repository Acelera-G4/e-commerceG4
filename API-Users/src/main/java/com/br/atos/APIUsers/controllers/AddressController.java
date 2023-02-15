package com.br.atos.APIUsers.controllers;

import com.br.atos.APIUsers.model.Address;
import com.br.atos.APIUsers.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/cep")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping("/{cep}")
    public ResponseEntity<Address> getCep(@PathVariable String cep){
        Address address = addressService.searchAddress(cep);
        return ResponseEntity.ok(address);
    }



}
