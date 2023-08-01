package com.thnakrean.backend.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
public class ApiException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
