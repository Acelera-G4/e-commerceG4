package com.br.atos.APIUsers.service;

import com.br.atos.APIUsers.exception.config.erros.AddressExceptionNotFound;
import com.br.atos.APIUsers.exception.config.erros.UserExceptionNotFound;
import com.br.atos.APIUsers.model.Address;
import com.br.atos.APIUsers.model.User;
import com.br.atos.APIUsers.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    AddressRepository addressRepository;


    public Address searchAddress(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return new RestTemplate().getForObject(url, Address.class);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address findAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressExceptionNotFound(("Id do usuário não localizado")));
    }

    public ResponseEntity<Address> updateAddress(Address address, @PathVariable Long id) {
       try{
           Address newAddress = addressRepository.getById(id);
                    newAddress.setCep(address.getCep());
                    newAddress.setStreet(address.getStreet());
                    newAddress.setNumber(address.getNumber());
                    newAddress.setComplement(address.getComplement());
                    newAddress.setCity(address.getCity());
                    newAddress.setUf(address.getUf());
                    return ResponseEntity.status(HttpStatus.OK).body(addressRepository.save(newAddress));
           } catch (Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

    public void deleteAddres(Long id) {
        try {
            addressRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new UserExceptionNotFound("Endereço não encontrado");
        }
    }


    public List<Address> getAllUsers() {
        return addressRepository.findAll();
    }
}