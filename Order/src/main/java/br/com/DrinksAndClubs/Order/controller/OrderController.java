package br.com.DrinksAndClubs.Order.controller;

import br.com.DrinksAndClubs.Order.model.Order;
import br.com.DrinksAndClubs.Order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order create (@RequestBody Order order){
        return orderService.create(order);
    }

    @GetMapping("/{id}")
    public Order getIdOrder(long id) {
        return orderService.getIdOrder(id);
    }

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

//    @PutMapping
//    public Order update(Order order){
//        return orderService.update(order);
//    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        orderService.delete(id);
    }

}
