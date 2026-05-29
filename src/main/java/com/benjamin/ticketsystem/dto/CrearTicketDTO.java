package com.benjamin.ticketsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CrearTicketDTO {
    
    @NotBlank(message = "El titulo es Obligatorio")
    @Size(min = 5, max = 100, message = "El titulo debe tener entre 5 y 100 caracteres")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 10, max = 500, message = "La categoria debe tener entre 10 y 500 caracteres")
    private String descripcion;

    @NotNull(message = "La categoria es Obligatoria")
    private Long categoriaId;
    
    @NotNull(message = "La prioridad es obligatoria")
    private Long prioridadId;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public Long getCategoriaId(){
        return categoriaId;
    }
    public void setCategoriaId(Long categoriaId){
        this.categoriaId = categoriaId;
    }
    public Long getPrioridadId(){
        return prioridadId;
    }
    public void setPrioridadId(Long prioridadId){
        this.prioridadId = prioridadId;
    }
    public Long getUsuarioId(){
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId){
        this.usuarioId = usuarioId;
    }
}
