package com.example.delivery.exception;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
	    log.error("An error occurred: ", message);

    }
}
