package com.br.atos.APIUsers.repository;


import com.br.atos.APIUsers.model.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditcardRepository extends JpaRepository<Creditcard, Long> {

}
