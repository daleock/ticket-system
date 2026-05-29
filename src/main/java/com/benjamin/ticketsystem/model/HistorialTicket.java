package com.benjamin.ticketsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_ticket")

public class HistorialTicket{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    
    @Column(name = "campo", nullable = false)
    private String campo;

    @Column(name = "estado_anterior")
    private String estadoAnterior;

    @Column(name = "estado_nuevo")
    private String estadoNuevo;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    //getters y setters
    public Long getId(){return id; }
    public void setId(Long id){this.id = id;}

    public Ticket getTicket(){return ticket; }
    public void setTicket(Ticket ticket){this.ticket = ticket;}

    public Usuario getUsuario(){return usuario; }
    public void setUsuario(Usuario usuario){this.usuario = usuario;}

    public String getCampo(){return campo; }
    public void setCampo(String campo){this.campo = campo;}

    public String getEstadoAnterior(){return estadoAnterior; }
    public void setEstadoAnterior(String estadoAnterior){this.estadoAnterior = estadoAnterior;}

    public String getEstadoNuevo(){return estadoNuevo; }
    public void setEstadoNuevo(String estadoNuevo){this.estadoNuevo = estadoNuevo;}

    public String getComentario(){return comentario; }
    public void setComentario(String comentario){this.comentario = comentario;}

    public LocalDateTime getCreatedAT(){return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt; }

}