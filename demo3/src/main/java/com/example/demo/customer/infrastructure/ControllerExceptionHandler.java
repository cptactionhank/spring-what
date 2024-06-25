package com.example.demo.customer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.customer.CustomerNotFoundException;
import com.example.demo.customer.DocTypeNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(CustomerNotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ResponseEntity<?> customerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @ExceptionHandler(DocTypeNotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ResponseEntity<?> docTypeNotFoundException(DocTypeNotFoundException ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}