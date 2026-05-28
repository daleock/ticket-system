package com.benjamin.ticketsystem.dto;

public class CrearTicketDTO {
    
    private String titulo;
    private String descripcion;
    private Long categoriaId;
    private Long prioridadId;
    
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
    public void setCategoriaId(long categoriaId){
        this.categoriaId = categoriaId;
    }
    public Long getPrioridadId(){
        return prioridadId;
    }
    public void setPrioridad(Long prioridadId){
        this.prioridadId = prioridadId;
    }
}
