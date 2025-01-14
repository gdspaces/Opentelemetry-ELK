package com.example.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DeliveryTime {
    @Id
    private String postalCode;
    private int days;

    // Getters and Setters
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

	public DeliveryTime(String postalCode, int days) {
		super();
		this.postalCode = postalCode;
		this.days = days;
	}
    
    public DeliveryTime() {
    }

	@Override
	public String toString() {
		return "DeliveryTime [postalCode=" + postalCode + ", days=" + days + "]";
	}

    
    
}
