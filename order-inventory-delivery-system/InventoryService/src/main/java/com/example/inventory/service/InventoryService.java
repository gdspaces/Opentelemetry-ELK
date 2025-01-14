package com.example.inventory.service;

import com.example.inventory.entity.Inventory;
import com.example.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public int getInventory(String productName) {
        return inventoryRepository.findById(productName).map(Inventory::getQuantity).orElse(0);
    }

    public String updateInventory(String productName, int quantity) {
        Inventory inventory = inventoryRepository.findById(productName).orElse(new Inventory());
        if (inventory.getQuantity() < quantity) {
            return "Insufficient stock";
        }
        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventoryRepository.save(inventory);
        return "Inventory updated";
    }
}
