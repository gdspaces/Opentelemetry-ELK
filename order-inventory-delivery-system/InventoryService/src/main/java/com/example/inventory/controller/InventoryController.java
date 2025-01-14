package com.example.inventory.controller;

import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/get")
    public int getInventory(@RequestParam String productName) {
        return inventoryService.getInventory(productName);
    }

    @PostMapping("/update")
    public String updateInventory(@RequestParam String productName, @RequestParam int quantity) {
        return inventoryService.updateInventory(productName, quantity);
    }
}
