package com.benjamin.ticketsystem.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler{

    //Maneja recursos no encontrados 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex){

        Map<String, Object> error = new LinkedHashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("Status", 404);
        error.put("error", "Not Found");
        error.put("mensaje", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);     
    }

    //Maneja errrores de validacion 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> erroresPorCampo = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            erroresPorCampo.put(error.getField(), error.getDefaultMessage());
        });
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 400);
        response.put("error", "Bad Request");
        response.put("mensaje", erroresPorCampo);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //Maneja cualquier otro error inesperado 
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex){
        Map<String,Object> error = new LinkedHashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("Status", 500);
        error.put("error","Internal Server Error");
        error.put("Mensaje", "Ocurrio un error inesperado");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);


    }
}