package com.app.dailyhistory_authentication.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistException extends ResponseStatusException {
    public EmailAlreadyExistException(String message){
        super(HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
