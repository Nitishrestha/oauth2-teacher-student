package com.nitish.self.teacherstudentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resource;

    public ResourceNotFoundException(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
