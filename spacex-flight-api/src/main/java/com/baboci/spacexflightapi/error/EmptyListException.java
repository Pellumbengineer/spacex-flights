package com.baboci.spacexflightapi.error;

import org.springframework.stereotype.Component;

@Component
public class EmptyListException extends RuntimeException{

    private String errorMessage;

    public EmptyListException(){}

    public EmptyListException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
