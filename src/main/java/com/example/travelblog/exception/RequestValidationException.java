package com.example.travelblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 10/08/2023 - 7:32 AM
 * @project travelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationException extends RuntimeException{
    public RequestValidationException(String message) {
        super(message);
    }
}
