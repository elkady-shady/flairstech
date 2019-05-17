package com.flairstech.world.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "INVALID_COUNTRY_CODE")
public class InvalidCountryCodeException extends Exception {

    private static final long serialVersionUID = 1L;


    public InvalidCountryCodeException(String message)
    {
        super(message);
    }
}
