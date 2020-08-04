package com.example.dealapps.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author NEJMEDDINE Ayoub
 * @created 03/08/2020 -10:57
 */
@Data
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class MyResourceNotFoundException extends Exception {


    public MyResourceNotFoundException() {
        super();
    }

    public MyResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyResourceNotFoundException(final String message) {
        super(message);
    }

    public MyResourceNotFoundException(final Throwable cause) {
        super(cause);
    }

}
