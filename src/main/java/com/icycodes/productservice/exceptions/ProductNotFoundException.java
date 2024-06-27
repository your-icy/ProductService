package com.icycodes.productservice.exceptions;

import lombok.Data;

@Data
public class ProductNotFoundException extends RuntimeException {

    private String errorCode;

    public ProductNotFoundException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
