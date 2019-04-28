package com.github.sigitisme.accountservice.controllers.exceptions;

public class NotFoundException extends Exception {

    private String message;

    public static NotFoundException sendException(String message){
        return new NotFoundException(message);
    }

    private NotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
