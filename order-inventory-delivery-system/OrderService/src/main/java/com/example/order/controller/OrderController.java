package com.example.order.controller;

import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@RequestParam String productName, @RequestParam String postalCode) {
        return orderService.createOrder(productName, postalCode);
    }

    @GetMapping("/track/{orderId}")
    public Order trackOrder(@PathVariable Long orderId) {
        return orderService.trackOrder(orderId);
    }
}
