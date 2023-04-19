package br.com.DrinksAndClubs.Order.services;

import br.com.DrinksAndClubs.Order.model.Order;
import br.com.DrinksAndClubs.Order.repository.OrderRepository;
import br.com.DrinksAndClubs.Order.exception.errors.OrderExceptionNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrdersById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderExceptionNotFound("ID do Pedido não encontrado!"));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public ResponseEntity updateOrder(@RequestBody Order order, Long id) {
        return orderRepository.findById(id).map(
                newOrder -> {

                    newOrder.setListProducts(order.getListProducts());
                    newOrder.setPayment(order.getPayment());
                    newOrder.setDelivery(order.isDelivery());
                    newOrder.setClientID(order.getClientID());
                    Order updatedOrder = orderRepository.save(newOrder);
                    return ResponseEntity.ok().body(updatedOrder);
                }).orElseThrow(() -> new OrderExceptionNotFound("ID não encontrado!"));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
