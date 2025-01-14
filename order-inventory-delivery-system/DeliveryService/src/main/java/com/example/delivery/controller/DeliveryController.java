package com.example.delivery.controller;

import com.example.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/getDeliveryTime")
    public int getDeliveryTime(@RequestParam String postalCode) {
        log.info("Inside method getDeliveryTime");
        return deliveryService.getDeliveryTime(postalCode);
    }
}
