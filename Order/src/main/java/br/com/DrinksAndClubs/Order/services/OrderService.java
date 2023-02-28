package br.com.DrinksAndClubs.Order.services;

import br.com.DrinksAndClubs.Order.model.Order;
import br.com.DrinksAndClubs.Order.repository.OrderRepository;
import br.com.DrinksAndClubs.Order.exception.errors.OrderExceptionNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order getIdOrder(long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderExceptionNotFound("Pedido não localizado"));
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public Order update(Order order){
        Order orderEntity = orderRepository.findById(order.getID()).orElseThrow();
        orderEntity.setID(order.getID());
        orderEntity.setNumber(order.getNumber());
        orderEntity.setId_product(order.getId_product());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setID_Credicard(order.getID_Credicard());
        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setID_Client(order.getID_Client());

        return orderRepository.save(orderEntity);
    }

    public void delete(Long id){
        try{
            orderRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Pedido não localizado");
        }
    }

}
