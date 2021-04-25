package com.store.management.store.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends ApplicationException {
    //@Value("${com.store.management.store.errorCode.3}")
    public static final String MESSAGE = "Customer does not exist.";
    public static final String ERROR_CODE = "3";

    public CustomerNotFoundException() {
        super(MESSAGE, ERROR_CODE);
    }
}
