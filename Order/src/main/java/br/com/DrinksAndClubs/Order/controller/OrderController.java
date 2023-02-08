package br.com.DrinksAndClubs.Order.controller;

import br.com.DrinksAndClubs.Order.model.Order;
import br.com.DrinksAndClubs.Order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

//    @GetMapping
//    public String get() {
//        return "microserviço order";
//    }

    private final OrderService orderService;

    @GetMapping
    public Order create (@RequestBody Order order){
        return orderService.create(order);
    }
}
