package br.com.DrinksAndClubs.Order.repository;

import br.com.DrinksAndClubs.Order.model.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditcardRepository extends JpaRepository<Creditcard, Long> {

}
