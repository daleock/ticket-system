package com.benjamin.ticketsystem.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler{

    //maneja recursos no encontrados
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object >> handleResourceNotFound(ResourceNotFoundException ex){

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("Status", 404);
        error.put("error", "Not Found");
        error.put("mensaje", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);     
    }

    //Maneja cualquier otro error inesperado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex){
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("Status", 500);
        error.put("error","Internal Server Error");
        error.put("Mensaje", "Ocurrio un error inesperado");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);


    }
}