package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String INVENTORY_URL = "http://localhost:8082/inventory";
    private static final String DELIVERY_URL = "http://localhost:8083/delivery";

    public String createOrder(String productName, String postalCode) {
        int quantity = 1;

        // Step 1: Check Inventory
        Integer inventoryCount = restTemplate.getForObject(INVENTORY_URL + "/get?productName=" + productName, Integer.class);
        if (inventoryCount == null || inventoryCount <= 0) {
            return "Product not in stock";
        }

        // Step 2: Get Delivery Time
        Integer deliveryDays = restTemplate.getForObject(DELIVERY_URL + "/getDeliveryTime?postalCode=" + postalCode, Integer.class);
        if (deliveryDays == null) {
            return "Delivery time not available";
        }
        LocalDate expectedDeliveryDate = LocalDate.now().plusDays(deliveryDays);

      // Step 3: Update Inventory
        restTemplate.postForObject(INVENTORY_URL + "/update?productName=" + productName + "&quantity=" + quantity, null, String.class);

        // Step 4: Save Order
        Order order = new Order();
        order.setProductName(productName);
        order.setQuantity(quantity);
        order.setPostalCode(postalCode);
        order.setDeliveryDate(expectedDeliveryDate);
        order = orderRepository.save(order);

        return "Order created with ID: " + order.getId();
    }

    public Order trackOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
