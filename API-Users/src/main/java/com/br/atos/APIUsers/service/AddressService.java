package com.br.atos.APIUsers.service;

import com.br.atos.APIUsers.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AddressService {


    public Address searchAddress(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return new RestTemplate().getForObject(url, Address.class);
    }
}
