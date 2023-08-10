package com.example.travelblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 10/08/2023 - 7:31 AM
 * @project travelBlog
 * @author Yosef Adel Mahmoud Saaid
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN)

public class UnAuthrized extends RuntimeException {
    public UnAuthrized(String message) {
        super(message);
    }
}