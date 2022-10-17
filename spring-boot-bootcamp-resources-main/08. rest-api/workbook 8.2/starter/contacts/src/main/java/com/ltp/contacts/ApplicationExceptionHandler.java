package com.ltp.contacts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException exception) {
    ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }
}
