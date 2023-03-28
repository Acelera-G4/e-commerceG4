package com.br.atos.APIUsers.repository;

import com.br.atos.APIUsers.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {



}


