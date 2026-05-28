package com.benjamin.ticketsystem.dto;

public class ActualizarTicketDTO {

    private String titulo;
    private String descripcion;
    private Long categoriaId;
    private Long prioridadId;
    private Long estadoId;
    

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
    public void setPrioridadId(Long prioridadId){
        this.prioridadId = prioridadId;
    }
    public Long getEstadoId(){
        return estadoId;
    }
    public void setEstadoId(Long estadoId){
        this.estadoId = estadoId;
    }
}
