package com.lloyds.humanreadableformat.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HumanReadableExceptions {
    @ExceptionHandler(InputTimeFormatException.class)
    public ResponseEntity<String> handlePersonNotFoundException(InputTimeFormatException inputTimeFormatException) {

        return new ResponseEntity<String>(inputTimeFormatException.getMessage(), HttpStatus.BAD_REQUEST);

    }
}
