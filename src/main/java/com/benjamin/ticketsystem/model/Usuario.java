package com.benjamin.ticketsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "usuario")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @Column ( name = "created_at")
    private LocalDateTime createdAt;

    @Column ( name = "updated_at")
    private LocalDateTime updatedAt;

}