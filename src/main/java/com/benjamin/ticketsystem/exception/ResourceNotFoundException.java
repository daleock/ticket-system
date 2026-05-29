package com.benjamin.ticketsystem.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
    
}
