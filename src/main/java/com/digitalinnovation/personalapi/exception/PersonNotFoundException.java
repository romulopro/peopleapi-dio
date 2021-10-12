package com.digitalinnovation.personalapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception{
    public PersonNotFoundException(long id){
        super("People not found with ID " + id);
    }
    
}
