package com.example.zemoga.application.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ZemogaExceptionResponse {
  private int code;
  private String message;
}
