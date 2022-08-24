package com.neosoft.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)   // to return client status that resource not found
public class ResourceNotFoundException extends  RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
