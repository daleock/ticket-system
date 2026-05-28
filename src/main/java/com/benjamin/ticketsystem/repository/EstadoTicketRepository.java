package com.benjamin.ticketsystem.repository;

import com.benjamin.ticketsystem.model.EstadoTicket;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EstadoTicketRepository extends JpaRepository <EstadoTicket, Long>{

    Optional<EstadoTicket> findByNombre(String nombre);
    
}
