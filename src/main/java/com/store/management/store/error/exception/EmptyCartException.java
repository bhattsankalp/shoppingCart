package com.store.management.store.error.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyCartException extends ApplicationException {
    //@Value("${com.store.management.store.errorCode.2}")
    public static final String MESSAGE = "Cart is empty";
    public static final String ERROR_CODE = "2";

    public EmptyCartException() {
        super(MESSAGE, ERROR_CODE);
    }
}
