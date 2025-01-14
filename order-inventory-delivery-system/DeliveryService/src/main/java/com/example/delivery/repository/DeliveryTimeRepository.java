package com.example.delivery.repository;

import com.example.delivery.model.DeliveryTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryTimeRepository extends JpaRepository<DeliveryTime, String> {}
