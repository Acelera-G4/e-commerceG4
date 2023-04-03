package com.br.atos.APIUsers.controllers;

import com.br.atos.APIUsers.model.Address;
import com.br.atos.APIUsers.model.User;
import com.br.atos.APIUsers.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping
    public List<Address> getAllAddrres() {
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    public Address getAddressId(@PathVariable Long id) {
        log.info("realizando pesquisa do id: ",id);
        return addressService.findAddressById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address createAddress(@RequestBody Address address){
        log.info("iniciando o cadastro de um usuário: {}", address);
        return addressService.createAddress(address);
//        return addressService.searchAddress(address.cep);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable Long id){
        log.info("Usuário sendo autualizado...");
        return addressService.updateAddress(address, id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAddress(@PathVariable Long id) {
        log.warn("Endereço sendo excluído..");
        addressService.deleteAddres(id);
        log.warn("Endereço excluido");
    }

}
