package com.example.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class DeliveryServiceApplication {

    public static void main(String[] args) {
	    log.info("DeliveryServiceApplication Started -");
        SpringApplication.run(DeliveryServiceApplication.class, args);
    }
}
