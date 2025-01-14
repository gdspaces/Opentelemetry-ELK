package com.example.delivery.service;

import com.example.delivery.repository.DeliveryTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.delivery.model.DeliveryTime;
import com.example.delivery.exception.DataNotFoundException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DeliveryService {
    @Autowired
    private DeliveryTimeRepository deliveryTimeRepository;

    public int getDeliveryTime(String postalCode) {
        log.info("Calling Database method to getDeliveryTime");
        return deliveryTimeRepository.findById(postalCode).map(DeliveryTime::getDays).orElseThrow(() -> new DataNotFoundException("No data found for postal code: " + postalCode));
    }
}
