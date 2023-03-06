package br.com.DrinksAndClubs.Order.repository;

import br.com.DrinksAndClubs.Order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
