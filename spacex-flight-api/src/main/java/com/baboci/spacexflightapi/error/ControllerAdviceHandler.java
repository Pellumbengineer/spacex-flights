package com.baboci.spacexflightapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<String> handleEmptyRocketList(EmptyListException emptyListException){
        return new ResponseEntity<>("There is no data coming from api! "+
                emptyListException.getErrorMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAnyException(Exception e){
        return new ResponseEntity<>("Something went wrong! " +e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
