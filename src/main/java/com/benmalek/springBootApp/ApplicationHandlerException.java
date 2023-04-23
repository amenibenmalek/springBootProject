package com.benmalek.springBootApp;

import com.benmalek.springBootApp.exception.ContactNotFoundException;
import com.benmalek.springBootApp.exception.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * class-level annotation that allows you to define global exception handlers
 */
@ControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler {

  /**
   * 1 - Defines the exception that you want the method to handle
   * 2 - The thrown exception can be accessed from the list of arguments
   * ExceptionHandler : method-level annotation that defines an exception handler.
   * @param ex
   * @return
   */
  @ExceptionHandler(ContactNotFoundException.class)
  public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers,
                                                                HttpStatusCode status, WebRequest request) {
    /*List<String> errors = new ArrayList<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
    return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);*/
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      System.out.println(error.getDefaultMessage());
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
