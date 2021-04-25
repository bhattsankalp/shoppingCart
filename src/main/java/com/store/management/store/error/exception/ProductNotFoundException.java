package com.store.management.store.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends ApplicationException {
    //@Value("${com.store.management.store.errorCode.1}")
    public static final String MESSAGE = "Product not available in stock";
    public static final String ERROR_CODE = "1";

    public ProductNotFoundException() {
        super(MESSAGE, ERROR_CODE);
    }
}
