package com.rachelcampbell.ecommerce.Exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ErrorMessage {
    private Date timestamp;
    private String message;
    public ErrorMessage(Date timestamp, String message) {
        super();
        this.timestamp = timestamp;
        this.message = message;
    }
}
