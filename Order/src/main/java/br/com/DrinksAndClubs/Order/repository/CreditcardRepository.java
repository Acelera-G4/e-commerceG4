package br.com.DrinksAndClubs.Order.repository;

import br.com.DrinksAndClubs.Order.model.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditcardRepository extends JpaRepository<Creditcard, Long> {

//    @Query("select * from tb_credit-card where name like %?%")
//    List<Creditcard> findAllByName(String name);
}
