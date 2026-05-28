package com.benjamin.ticketsystem.repository;

import com.benjamin.ticketsystem.model.Prioridad;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrioridadRepository extends JpaRepository <Prioridad, Long> {
    
    Optional<Prioridad> findByNombre(String nombre);
    
}
