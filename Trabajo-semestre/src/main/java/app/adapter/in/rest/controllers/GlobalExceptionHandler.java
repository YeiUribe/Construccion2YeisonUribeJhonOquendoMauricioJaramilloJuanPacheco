package app.adapter.in.rest.controllers;

import app.adapter.rest.response.ApiResponse;
import app.adapter.rest.response.ErrorResponse;
import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InputsException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleInputs(InputsException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("Error de validación");
        error.setDetail(ex.getMessage());
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        
        return new ResponseEntity<>(
            ApiResponse.error("Solicitud inválida", Arrays.asList(ex.getMessage())),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleBusiness(BusinessException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("Error de negocio");
        error.setDetail(ex.getMessage());
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.CONFLICT.value());
        
        return new ResponseEntity<>(
            ApiResponse.error("Conflicto en la operación", Arrays.asList(ex.getMessage())),
            HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleUnexpected(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("Error interno del servidor");
        error.setDetail(ex.getMessage());
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        
        return new ResponseEntity<>(
            ApiResponse.error("Error interno del servidor", Arrays.asList(ex.getMessage())),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}