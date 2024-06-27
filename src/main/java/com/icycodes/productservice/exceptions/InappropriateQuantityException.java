package com.icycodes.productservice.exceptions;

import lombok.Data;

@Data
public class InappropriateQuantityException extends RuntimeException{

    private String errorCode;

    public InappropriateQuantityException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
