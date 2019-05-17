package com.flairstech.world.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "INTERNAL_ERROR")
public class DatabaseServerDown extends Exception {

    private static final long serialVersionUID = 1L;


    public DatabaseServerDown(String message)
    {
        super(message);
    }
}
