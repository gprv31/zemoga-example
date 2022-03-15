package com.example.zemoga.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ZemogaExceptionResponse> generalException(Exception e) {
    ZemogaExceptionResponse zemogaExceptionResponse = new ZemogaExceptionResponse();
    zemogaExceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    zemogaExceptionResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(zemogaExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
