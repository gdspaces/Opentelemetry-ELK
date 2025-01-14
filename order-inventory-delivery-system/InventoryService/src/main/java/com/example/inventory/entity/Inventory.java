package com.example.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    private String productName;
    private int quantity;

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public Inventory(String productName, int quantity) {
		super();
		this.productName = productName;
		this.quantity = quantity;
	}
    
	public Inventory() {
	}

	@Override
	public String toString() {
		return "Inventory [productName=" + productName + ", quantity=" + quantity + "]";
	}
	
    
}
